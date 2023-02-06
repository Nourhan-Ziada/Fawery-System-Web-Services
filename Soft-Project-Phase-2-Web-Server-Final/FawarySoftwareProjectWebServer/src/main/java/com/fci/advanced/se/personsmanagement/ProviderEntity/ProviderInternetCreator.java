package com.fci.advanced.se.personsmanagement.ProviderEntity;

import com.fci.advanced.se.personsmanagement.ProviderEntity.Internt.*;
import com.fci.advanced.se.personsmanagement.ProviderEntity.Mobile.VodafoneMobileProviderEntity;

import java.util.List;
import java.util.Objects;

public class ProviderInternetCreator implements ProviderFactory{
    @Override
    public IProvider createProvider(List<String> providers) {
        if(Objects.equals(providers.get(0), "OrangeInternetProvider"))
        {
            OrangeInternetProviderEntity orangeInternetProviderEntity = new OrangeInternetProviderEntity();
            orangeInternetProviderEntity.setMobileNumber(providers.get(1));
            orangeInternetProviderEntity.setInternetAmount(Float.parseFloat(providers.get(2)));
            return orangeInternetProviderEntity;
        }
        if(Objects.equals(providers.get(0), "WeInternetProvider"))
        {
            WeInternetProviderEntity weInternetProviderEntity = new WeInternetProviderEntity();
            weInternetProviderEntity.setMobileNumber(providers.get(1));
            weInternetProviderEntity.setInternetAmount(Float.parseFloat(providers.get(2)));
            return weInternetProviderEntity;
        }
        if(Objects.equals(providers.get(0), "VodafoneInternetProvider"))
        {
            VodafoneInternetProviderEntity vodafoneInternetProviderEntity = new VodafoneInternetProviderEntity();
            vodafoneInternetProviderEntity.setMobileNumber(providers.get(1));
            vodafoneInternetProviderEntity.setInternetAmount(Float.parseFloat(providers.get(2)));
            return vodafoneInternetProviderEntity;
        }
        if(Objects.equals(providers.get(0), "EtisalatInternetProvider"))
        {
            EtisalatInternetProviderEntity etisalatInternetProviderEntity = new EtisalatInternetProviderEntity();
            etisalatInternetProviderEntity.setMobileNumber(providers.get(1));
            etisalatInternetProviderEntity.setInternetAmount(Float.parseFloat(providers.get(2)));
            return etisalatInternetProviderEntity;
        }
        return null;
    }
}
