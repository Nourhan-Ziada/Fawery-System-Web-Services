package com.fci.advanced.se.personsmanagement.Service_Package;


import com.fci.advanced.se.personsmanagement.ProviderEntity.IProvider;

public class LandLineService extends Service{
    @Override
    public float request(IProvider telecomEgyptProvider) {
        float totalCost = telecomEgyptProvider.retrieveAmount();
        setServiceCost((float) (0.02*totalCost));
        totalCost += getServiceCost();
        return totalCost;
    }
}
