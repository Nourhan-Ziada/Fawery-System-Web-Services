package com.fci.advanced.se.personsmanagement.ProviderEntity.Internt;

public class EtisalatInternetProviderEntity extends InternetProviderEntity{
    @Override
    public float retrieveAmount() {
        return getInternetAmount();
    }
}
