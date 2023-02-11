package com.currencies.ecbrates.service;

import com.currencies.ecbrates.model.ModelHolder;
import com.currencies.ecbrates.model.Quote;

// Serivce for use within Controller to hide ModelHolder
public interface CurrenciesService {


    public String[] getSymbols();

    public Quote getCurrency(String currency);

    public Quote[] getCurrencies();
}
