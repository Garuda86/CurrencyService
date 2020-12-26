package ru.currencyservice.currencyexchange.model;


import java.util.Map;

public class Quote {
    private String disclaimer;
    private String license;
    private Integer timestamp;

    private String base;

    private Map<String, Double> rates;

    public Integer getTimeStamp() {
        return timestamp;
    }

    public void setTimeStamp(Integer timeStamp) {
        this.timestamp = timeStamp;
    }

    public Map<String, Double> getRates() {
        return rates;
    }

    public void setRates(Map<String, Double> rates) {
        this.rates = rates;
    }

    public String getDisclaimer() {
        return disclaimer;
    }

    public void setDisclaimer(String disclaimer) {
        this.disclaimer = disclaimer;
    }

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }
}
