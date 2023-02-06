package com.fci.advanced.se.personsmanagement.Service_Package;

import com.fci.advanced.se.personsmanagement.ProviderEntity.IProvider;

public class InternetPaymentService extends Service{
    @Override
    public float request(IProvider internetProvider) {
        float totalCost = internetProvider.retrieveAmount();
        setServiceCost((float) (0.02*totalCost));
        totalCost += getServiceCost();
        return totalCost;
    }
}
