package com.fci.advanced.se.personsmanagement.ProviderEntity.Mobile;

public class WeMobileProviderEntity extends MobileProviderEntity{
    public String getGmail() {
        return gmail;
    }

    public void setGmail(String gmail) {
        this.gmail = gmail;
    }

    private String gmail;
    @Override
    public float retrieveAmount() {
        return getRechargeAmount();
    }
}
