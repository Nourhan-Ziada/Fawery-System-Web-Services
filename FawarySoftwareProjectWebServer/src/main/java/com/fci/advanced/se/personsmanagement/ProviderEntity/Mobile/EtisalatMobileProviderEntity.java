package com.fci.advanced.se.personsmanagement.ProviderEntity.Mobile;

public class EtisalatMobileProviderEntity extends MobileProviderEntity{
    @Override
    public float retrieveAmount() {
        return getRechargeAmount();
    }
}
