package com.currencies.ecbrates.model;

//public class Quote {
//    String currency;
//    String rate;
//}
public record Quote (String currency, String rate){

    @Override
    public String toString() {
        return ModelHolder.baseCurrency + currency + ' ' + rate;
    }
}
