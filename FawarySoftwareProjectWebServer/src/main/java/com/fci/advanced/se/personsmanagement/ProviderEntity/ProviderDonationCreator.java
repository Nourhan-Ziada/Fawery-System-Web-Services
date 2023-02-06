package com.fci.advanced.se.personsmanagement.ProviderEntity;

import com.fci.advanced.se.personsmanagement.ProviderEntity.Internt.OrangeInternetProviderEntity;

import java.util.List;
import java.util.Objects;

public class ProviderDonationCreator implements ProviderFactory{
    @Override
    public IProvider createProvider(List<String> providers) {
        if(Objects.equals(providers.get(0), "Donation"))
        {
            DonationEntity donationEntity = new DonationEntity();
            donationEntity.setMobileNumber(providers.get(1));
            donationEntity.setDonationPlace(providers.get(2));
            donationEntity.setDonateAmount(Float.parseFloat(providers.get(3)));
            return donationEntity;
        }
        return null;
    }
}
