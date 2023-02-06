package com.fci.advanced.se.personsmanagement.Service_Package;

import com.fci.advanced.se.personsmanagement.ProviderEntity.IProvider;

public class MobileRechargeService extends Service{
    @Override
    public float request( IProvider MobileProvider ) {
        float totalCost = MobileProvider.retrieveAmount();
        setServiceCost((float) (0.02 * totalCost));
        totalCost += getServiceCost();
        return totalCost;
    }

}
