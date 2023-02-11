package com.currencies.ecbrates.service;


import com.currencies.ecbrates.EcbFetcher;
import com.currencies.ecbrates.EcbParser;
import com.currencies.ecbrates.model.ModelHolder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Slf4j
//@EnableAsync
@Component
public class RatesRefreshScheduler {

    @Autowired
    CurrenciesServiceImpl service;

    int counter = 0;

    //@Async
    //@Scheduled(fixedRate = 30000) //30s
    @Scheduled(cron = "${cron.expression}")
    public void refreshEcbRates(){
        log.info("refreshing ECB rates...");

        String str = EcbFetcher.fetch();
        ModelHolder holder = EcbParser.parse(str);
        log.info(holder.toString());
        //holder.print();

        service.updateRates(holder);
        counter++;
        log.info("ECB rates were updated for {} time.", counter);
    }
}
