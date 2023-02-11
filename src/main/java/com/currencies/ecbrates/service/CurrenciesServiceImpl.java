package com.currencies.ecbrates.service;

import com.currencies.ecbrates.model.ModelHolder;
import com.currencies.ecbrates.model.Quote;
import org.springframework.stereotype.Service;

@Service
// Serivce for use within Controller to hide ModelHolder
public class CurrenciesServiceImpl implements CurrenciesService {

    ModelHolder holder = ModelHolder.EMPTY;

    public void updateRates(ModelHolder mh){
        holder = mh;
    }

    @Override
    public String[] getSymbols(){
        return holder.getSymbols();
    }
    @Override
    public Quote getCurrency(String currency){
        return holder.getCurrency(currency);
    }
    @Override
    public Quote[] getCurrencies(){
        return holder.getCurrencies();
    }
}
