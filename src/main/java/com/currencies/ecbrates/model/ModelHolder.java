package com.currencies.ecbrates.model;

import com.currencies.ecbrates.service.CurrenciesService;

import java.util.Arrays;

public class ModelHolder implements CurrenciesService {

    public static final ModelHolder EMPTY = new ModelHolder();
    static {
        EMPTY.date = "EMPTY";
    }

    public static final String baseCurrency = "EUR";
    String date;

    Quote[] quotes = new Quote[100];
    int n = 0;

    public void addQuote(Quote q){
        quotes[n++]=q;
    }
    public void setDate(String d){
        date = d;
    }


    @Override
    public String[] getSymbols(){
        String[] a = new String[n+1];
        a[0]=baseCurrency;
        for(int i=0; i<n; i++){
            a[1+i]=quotes[i].currency();
        }
        return a;
    }

    @Override
    public Quote getCurrency(String currency){
        for(int i=0; i<n; i++){
            Quote q = quotes[i];
            String c= q.currency();
            if (c.equalsIgnoreCase(currency)){ // TODO currencies search and comparison in separate class Currency
                return q;
            }
        }
        return null;
    }

    @Override
    public Quote[] getCurrencies(){
        Quote[] copiedArray = new Quote[n];
        System.arraycopy(quotes, 0, copiedArray, 0, n);
        return copiedArray;
    }

    // ------


    @Override
    public String toString() {
        return "ModelHolder{" +
                "date='" + date + '\'' +
                ", n=" + n +
                ", quotes=" + Arrays.toString(quotes) +
                '}';
    }

    public void print(){
        System.out.println(date);
        System.out.println(n);
        for(int i=0; i<n; i++){
            String s = quotes[i].toString();
            System.out.println(s);
        }
    }
}
