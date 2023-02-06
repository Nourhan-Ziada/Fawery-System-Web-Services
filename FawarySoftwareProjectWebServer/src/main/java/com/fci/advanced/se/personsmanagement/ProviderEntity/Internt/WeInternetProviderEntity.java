package com.fci.advanced.se.personsmanagement.ProviderEntity.Internt;

public class WeInternetProviderEntity extends InternetProviderEntity{
    @Override
    public float retrieveAmount() {
        return getInternetAmount();
    }
}
