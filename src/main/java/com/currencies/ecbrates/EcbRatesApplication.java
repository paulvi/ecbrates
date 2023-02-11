package com.currencies.ecbrates;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@Slf4j
@SpringBootApplication
@EnableScheduling
public class EcbRatesApplication {

	public static void main(String[] args) {
		SpringApplication.run(EcbRatesApplication.class, args);
	}

}
