package com.example.bitcoinprice.entity;

import java.io.Serializable;

public class Country implements Serializable {

    private int code;
    private String symbol;
    private double rate;
    private String description;

    public Country() {
        this.code = 0;
        this.symbol = "";
        this.rate = 0;
        this.description = "";
    }

    public Country(int code, String symbol, double rate, String description) {
        this.code = code;
        this.symbol = symbol;
        this.rate = rate;
        this.description = description;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Country{" +
                "code=" + code +
                ", symbol='" + symbol + '\'' +
                ", rate=" + rate +
                ", description='" + description + '\'' +
                '}';
    }
}
