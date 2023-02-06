package com.fci.advanced.se.personsmanagement.Service_Package;

import org.springframework.stereotype.Component;

@org.springframework.stereotype.Service
public class AllService {
    private ServiceType serviceTypes[] = ServiceType.values();
    private ServiceFactory serviceFactory;
    private Service service;
    public void setServiceFactory(ServiceFactory serviceFactory) {
        this.serviceFactory = serviceFactory;
    }
    public void setupService()
    {
        ServiceFactory serviceCreator = new ServiceCreator();
        setServiceFactory(serviceCreator);
        for (ServiceType serviceType1: serviceTypes) {
            service = serviceFactory.CreateService(serviceType1);
            service.setServiceName(serviceType1);
            ServiceEntity.addService(service);
        }
    }
}
