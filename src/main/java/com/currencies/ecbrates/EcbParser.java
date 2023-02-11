package com.currencies.ecbrates;

import com.currencies.ecbrates.model.ModelHolder;
import com.currencies.ecbrates.model.Quote;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class EcbParser {

    // Content example
    //Date, USD, JPY, BGN, CZK, DKK, GBP, HUF, PLN, RON, SEK, CHF, ISK, NOK, TRY, AUD, BRL, CAD, CNY, HKD, IDR, ILS, INR, KRW, MXN, MYR, NZD, PHP, SGD, THB, ZAR,
    //10 February 2023, 1.0690, 139.88, 1.9558, 23.692, 7.4445, 0.88348, 389.78, 4.7810, 4.9020, 11.1630, 0.9872, 152.10, 10.8710, 20.1357, 1.5432, 5.6245, 1.4364, 7.2837, 8.3916, 16233.33, 3.7820, 88.2475, 1354.10, 20.0540, 4.6314, 1.6904, 58.207, 1.4199, 36.057, 19.0834,
    // There is no need for special CSV reader.
    // Just reading into 2 arrays of Strings.

    public static ModelHolder parse(String s){



        ModelHolder holder = new ModelHolder();

        String[] lines = s.split("\\n");
        String lineCur = lines[0];
        String lineRate = lines[1];

        String[] currencies = lineCur.split(",");
        String[] rates = lineRate.split(",");

        holder.setDate(rates[0]);

        int n = currencies.length-1; // -1 because both lines end with ','
        for(int i=1; i<n; i++){
            String cur = currencies[i].trim();
//            if (cur.isEmpty()){
//                continue;
//            }
            Quote q = new Quote(cur, rates[i].trim())    ;
            holder.addQuote(q);
        }

        return holder;

    }

    public static void main(String[] args) {
        String str = EcbFetcher.fetch();
        //log.info(str);
        ModelHolder holder = parse(str);
        log.info(holder.toString());
        holder.print();
    }
}
