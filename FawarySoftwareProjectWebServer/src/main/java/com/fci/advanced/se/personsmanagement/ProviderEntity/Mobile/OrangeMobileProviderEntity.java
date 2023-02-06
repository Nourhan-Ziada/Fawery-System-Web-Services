package com.fci.advanced.se.personsmanagement.ProviderEntity.Mobile;

public class OrangeMobileProviderEntity extends MobileProviderEntity {


    @Override
    public float retrieveAmount() {
        return getRechargeAmount();
    }
}
