package com.fci.advanced.se.personsmanagement.ProviderEntity;

import com.fci.advanced.se.personsmanagement.ProviderEntity.Internt.InternetProviderEntity;
import com.fci.advanced.se.personsmanagement.ProviderEntity.Internt.OrangeInternetProviderEntity;
import com.fci.advanced.se.personsmanagement.ProviderEntity.Mobile.EtisalatMobileProviderEntity;
import com.fci.advanced.se.personsmanagement.ProviderEntity.Mobile.OrangeMobileProviderEntity;
import com.fci.advanced.se.personsmanagement.ProviderEntity.Mobile.VodafoneMobileProviderEntity;
import com.fci.advanced.se.personsmanagement.ProviderEntity.Mobile.WeMobileProviderEntity;

import java.util.List;
import java.util.Objects;

import static com.fci.advanced.se.personsmanagement.Service_Package.ServiceType.MobileRecharge;

public class ProviderMobileCreator implements ProviderFactory {
    @Override
    public IProvider createProvider(List<String> providers) {
        if(Objects.equals(providers.get(0), "vodafoneMobileProvider"))
        {
            VodafoneMobileProviderEntity vodafoneMobileProviderEntity = new VodafoneMobileProviderEntity();
            vodafoneMobileProviderEntity.setMobileNumber(providers.get(1));
            vodafoneMobileProviderEntity.setRechargeAmount(Float.parseFloat(providers.get(2)));
            vodafoneMobileProviderEntity.setNationalID(providers.get(3));
            return vodafoneMobileProviderEntity;
        }
        if(Objects.equals(providers.get(0), "OrangeMobileProvider"))
        {
            OrangeMobileProviderEntity orangeMobileProviderEntity = new OrangeMobileProviderEntity();
            orangeMobileProviderEntity.setMobileNumber(providers.get(1));
            orangeMobileProviderEntity.setRechargeAmount(Float.parseFloat(providers.get(2)));
            return orangeMobileProviderEntity;
        }
        if(Objects.equals(providers.get(0), "WeMobileProvider"))
        {
            WeMobileProviderEntity weMobileProviderEntity = new WeMobileProviderEntity();
            weMobileProviderEntity.setMobileNumber(providers.get(1));
            weMobileProviderEntity.setRechargeAmount(Float.parseFloat(providers.get(2)));
            weMobileProviderEntity.setGmail(providers.get(3));
            return weMobileProviderEntity;
        }
        if(Objects.equals(providers.get(0), " EtisalatMobileProvider"))
        {
            EtisalatMobileProviderEntity etisalatMobileProviderEntity = new EtisalatMobileProviderEntity();
            etisalatMobileProviderEntity.setMobileNumber(providers.get(1));
            etisalatMobileProviderEntity.setRechargeAmount(Float.parseFloat(providers.get(2)));
            return etisalatMobileProviderEntity;
        }
        return null;
    }
}
