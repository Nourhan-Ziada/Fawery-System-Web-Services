package com.fci.advanced.se.personsmanagement.PaymentFactroy_Controller;

import com.fci.advanced.se.personsmanagement.PaymentMethod_Package.*;

import java.util.List;
import java.util.Objects;

public class PaymentCreator implements PaymentFactory {
    @Override
    public Payment createPaymentMethod(List<String> paymentData) {
        if(Objects.equals(paymentData.get(0), "CreditCard"))
        {
            CreditCard creditCard = new CreditCard();
            creditCard.setCreditNumber(paymentData.get(1));
            creditCard.setCVV(paymentData.get(2));
            return creditCard;
        }
        if(Objects.equals(paymentData.get(0), "CacheOnDelivery"))
        {
            CacheOnDilaver cacheOnDilaver = new CacheOnDilaver();
            cacheOnDilaver.setFirstName(paymentData.get(1));
            cacheOnDilaver.setMobileNumber(paymentData.get(2));
            cacheOnDilaver.setGovernmentName(paymentData.get(3));
            cacheOnDilaver.setCityName(paymentData.get(4));
            cacheOnDilaver.setStreetName(paymentData.get(5));
            cacheOnDilaver.setApartmentNumber(Integer.parseInt(paymentData.get(6)));
            return cacheOnDilaver;
        }
        if(Objects.equals(paymentData.get(0), "Wallet"))
        {
            WalletPayment walletPayment = new WalletPayment();
            return walletPayment;
        }
        return null;
    }
}
