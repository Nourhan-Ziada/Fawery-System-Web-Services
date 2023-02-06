package com.fci.advanced.se.personsmanagement.ProviderEntity;

public class DonationEntity implements IProvider{
    protected String mobileNumber;
    protected float donateAmount;
    protected String donationPlace;

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public void setDonateAmount(float donateAmount) {
        this.donateAmount = donateAmount;
    }

    public String getDonationPlace() {
        return donationPlace;
    }

    public void setDonationPlace(String donationPlace) {
        this.donationPlace = donationPlace;
    }

    public float getDonateAmount() {
        return donateAmount;
    }

    public float retrieveAmount()
    {
        return getDonateAmount();
    }
}
