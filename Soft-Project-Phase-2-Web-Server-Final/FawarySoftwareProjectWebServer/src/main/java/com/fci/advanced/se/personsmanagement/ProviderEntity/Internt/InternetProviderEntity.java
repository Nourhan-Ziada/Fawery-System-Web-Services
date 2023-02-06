package com.fci.advanced.se.personsmanagement.ProviderEntity.Internt;

import com.fci.advanced.se.personsmanagement.ProviderEntity.IProvider;

public abstract class InternetProviderEntity implements IProvider {
    protected String mobileNumber;
    protected float internetAmount;

    public float getInternetAmount() {
        return internetAmount;
    }

    public void setInternetAmount(float internetAmount) {
        this.internetAmount = internetAmount;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }
    public abstract float retrieveAmount ();
}