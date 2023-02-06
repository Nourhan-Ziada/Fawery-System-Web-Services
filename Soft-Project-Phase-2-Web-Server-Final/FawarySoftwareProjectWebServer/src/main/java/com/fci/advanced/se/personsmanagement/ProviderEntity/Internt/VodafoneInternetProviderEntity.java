package com.fci.advanced.se.personsmanagement.ProviderEntity.Internt;

public class VodafoneInternetProviderEntity extends InternetProviderEntity{
    @Override
    public float retrieveAmount() {
        return getInternetAmount();
    }
}
