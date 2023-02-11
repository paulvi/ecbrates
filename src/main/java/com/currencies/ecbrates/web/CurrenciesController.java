package com.currencies.ecbrates.web;

import com.currencies.ecbrates.model.Quote;
import com.currencies.ecbrates.service.CurrenciesService;
import com.currencies.ecbrates.service.CurrenciesServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrenciesController {

    @Autowired
    CurrenciesServiceImpl service;


    @GetMapping("/symbols")
    public String[] getSymbols(){
        return service.getSymbols();
    }

    @GetMapping("/currencies")
    //    - GET /currencies/ returns all exchange rates
    public Quote[] getCurrencies(){

        return service.getCurrencies();
    }

    @GetMapping("/currencies/{currency}")
    //- GET /currencies/SYMBOL returns the exchange rate for the specified currency
    public Quote getCurrency(@PathVariable String currency){
        return service.getCurrency(currency);
    }
}
