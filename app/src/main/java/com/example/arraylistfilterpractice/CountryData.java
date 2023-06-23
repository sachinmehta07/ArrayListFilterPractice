package com.example.arraylistfilterpractice;

public class CountryData {
    private int countryId;
    private String countryName;

    public CountryData(int countryId, String countryName) {
        this.countryId = countryId;
        this.countryName = countryName;
    }

    public int getCountryId() {
        return countryId;
    }

    public String getCountryName() {
        return countryName;
    }
}
