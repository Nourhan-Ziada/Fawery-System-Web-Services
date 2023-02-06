package com.fci.advanced.se.personsmanagement.ProviderEntity.Mobile;


import com.fci.advanced.se.personsmanagement.ProviderEntity.IProvider;
import lombok.AllArgsConstructor;

public abstract class MobileProviderEntity implements IProvider {

    protected String mobileNumber;
    protected float rechargeAmount;
    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public float getRechargeAmount() {
        return rechargeAmount;
    }
    public void setRechargeAmount(float rechargeAmount) {
        this.rechargeAmount = rechargeAmount;
    }

    public abstract float retrieveAmount ();

}
