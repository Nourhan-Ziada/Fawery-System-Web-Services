package com.fci.advanced.se.personsmanagement.ProviderEntity;

import com.fci.advanced.se.personsmanagement.ProviderEntity.Internt.OrangeInternetProviderEntity;
import com.fci.advanced.se.personsmanagement.ProviderEntity.LandLine.LandLineQuarter;
import com.fci.advanced.se.personsmanagement.ProviderEntity.LandLine.landLineMonthly;

import java.util.List;
import java.util.Objects;

public class ProviderLandLineCreator implements ProviderFactory{
    @Override
    public IProvider createProvider(List<String> providers) {
        if(Objects.equals(providers.get(0), "LandLineMonthly"))
        {
            landLineMonthly landLineMonthly = new landLineMonthly();
            landLineMonthly.setMobileNumber(providers.get(1));
            return landLineMonthly;
        }
        if(Objects.equals(providers.get(0), "LandLineQuarter"))
        {
            LandLineQuarter landLineQuarter = new LandLineQuarter();
            landLineQuarter.setMobileNumber(providers.get(1));
            return landLineQuarter;
        }
        return null;
    }
}
