package com.fci.advanced.se.personsmanagement.PaymentMethod_Package;

import com.fci.advanced.se.personsmanagement.User.User;

public class CacheOnDilaver implements Payment{
    private String FirstName;
    private String mobileNumber;
    private String streetName;
    private int apartmentNumber;
    private String governmentName;
    private  String cityName;
    public CacheOnDilaver(){};
    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public void setApartmentNumber(int apartmentNumber) {
        this.apartmentNumber = apartmentNumber;
    }

    public void setGovernmentName(String governmentName) {
        this.governmentName = governmentName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }
    @Override
    public float pay(User user, float totalCost) {
        return totalCost;
    }
}
