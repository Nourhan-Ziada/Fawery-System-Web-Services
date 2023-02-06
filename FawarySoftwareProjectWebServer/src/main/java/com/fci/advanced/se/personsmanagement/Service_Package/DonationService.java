package com.fci.advanced.se.personsmanagement.Service_Package;


import com.fci.advanced.se.personsmanagement.ProviderEntity.IProvider;

public class DonationService extends Service{
    @Override
    public float request(IProvider donationProvider ) {
        float totalCost = donationProvider.retrieveAmount();
        setServiceCost((float) (0.02*totalCost));
        totalCost += getServiceCost();
        return totalCost;
    }
}
