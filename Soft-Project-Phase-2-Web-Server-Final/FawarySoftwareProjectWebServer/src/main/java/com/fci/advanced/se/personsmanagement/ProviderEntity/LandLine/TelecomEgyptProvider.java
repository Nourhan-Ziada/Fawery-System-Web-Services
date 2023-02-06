package com.fci.advanced.se.personsmanagement.ProviderEntity.LandLine;

import com.fci.advanced.se.personsmanagement.ProviderEntity.IProvider;

public abstract class TelecomEgyptProvider implements IProvider {

    protected String mobileNumber;
    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }
    public abstract float retrieveAmount();

}
