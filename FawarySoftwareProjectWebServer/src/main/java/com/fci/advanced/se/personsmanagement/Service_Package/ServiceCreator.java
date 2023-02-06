package com.fci.advanced.se.personsmanagement.Service_Package;

public class ServiceCreator implements ServiceFactory {

    public  Service CreateService(ServiceType serviceType)
    {
        if(serviceType == ServiceType.MobileRecharge)
        {
            return (new MobileRechargeService());
        }
        if(serviceType == ServiceType.InternetPayment)
            return (new InternetPaymentService());
        if(serviceType == ServiceType.Donation)
            return (new DonationService());
        if(serviceType == ServiceType.Landline)
            return (new LandLineService());

        return null;
    }
}
