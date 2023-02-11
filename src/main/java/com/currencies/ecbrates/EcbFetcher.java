package com.currencies.ecbrates;

import lombok.extern.slf4j.Slf4j;

import java.io.*;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

@Slf4j
public class EcbFetcher {

    public static String FILE_URL = "https://www.ecb.europa.eu/stats/eurofxref/eurofxref.zip";
    static String FILE_NAME = "eurofxref.zip";
    static int BUFFER_SIZE = 1024; //enough for reading daily ECB rates zip

    // Implementation notes: it may be possible to unzip InputStream directly from remote location,
    // however making clear steps helps judge on error reason and not to take unnecessary actions.
    public static String fetch(){

        byte buffer[] = new byte[BUFFER_SIZE];

        // 1 - get from remote location
        // stream within try() contruct brackets are closed automatically
        try (BufferedInputStream in = new BufferedInputStream(new URL(FILE_URL).openStream());
             FileOutputStream fileOutputStream = new FileOutputStream(FILE_NAME)) {

            int bytesRead;
            while ((bytesRead = in.read(buffer, 0, BUFFER_SIZE)) != -1) {
                fileOutputStream.write(buffer, 0, bytesRead);
            }
        } catch (IOException e) {
            log.error("IOException while reading from ECB", e);
            return null;
        }
        log.info("Downloaded {}", FILE_NAME);

        // 2 - unzip CSV from ZIP
        File destDir = new File(".");
        ZipEntry zipEntry;
        try (ZipInputStream zis = new ZipInputStream(new FileInputStream(FILE_NAME));  ) {
            zipEntry = zis.getNextEntry();
            while (zipEntry != null) {
                String entryName = zipEntry.getName();
                File newFile = new File(destDir, entryName);
                if (zipEntry.isDirectory()) {
                    log.error("Unexpected directory entry in zip file!");
                    return null;
                }
                FileOutputStream fos = new FileOutputStream(newFile);
                int len;
                while ((len = zis.read(buffer)) > 0) {
                    fos.write(buffer, 0, len);
                }
                fos.close();
                log.info("Unzipped {}", entryName);

                zipEntry = zis.getNextEntry();
            }//while
        } catch (IOException e) {
            log.error("IOException while unzipping ECB zip file", e);
            return null;
        }

        // Content example
        //Date, USD, JPY, BGN, CZK, DKK, GBP, HUF, PLN, RON, SEK, CHF, ISK, NOK, TRY, AUD, BRL, CAD, CNY, HKD, IDR, ILS, INR, KRW, MXN, MYR, NZD, PHP, SGD, THB, ZAR,
        //10 February 2023, 1.0690, 139.88, 1.9558, 23.692, 7.4445, 0.88348, 389.78, 4.7810, 4.9020, 11.1630, 0.9872, 152.10, 10.8710, 20.1357, 1.5432, 5.6245, 1.4364, 7.2837, 8.3916, 16233.33, 3.7820, 88.2475, 1354.10, 20.0540, 4.6314, 1.6904, 58.207, 1.4199, 36.057, 19.0834,
        // There is no need for special CSV reader.
        // Just reading into 2 arrays of Strings.

        Path filePath = Path.of("eurofxref.csv");

        String content = "";
        try {
                content = Files.readString(filePath);
        } catch (IOException e) {
            log.error("IOException while reading String from CSV file", e);
            return null;
        }
        log.debug(content);

        return content;
    } //fetch()

    public static void main(String[] args) {
        String str = fetch();
        //log.info(str);
    }


}
