package com.fci.advanced.se.personsmanagement.Service_Package;

import com.fci.advanced.se.personsmanagement.ProviderEntity.IProvider;

public abstract class Service {
    private float serviceCost;
    private int serviceID; // might be cancelled
    protected ServiceType serviceName;

    public ServiceType getServiceName() {
        return serviceName;
    }

    public void setServiceName(ServiceType serviceName) {
        this.serviceName = serviceName;
    }

    public float getServiceCost() {
        return serviceCost;
    }

    public void setServiceCost(float serviceCost) {
        this.serviceCost = serviceCost;
    }

    public int getServiceID() {
        return serviceID;
    }

    public void setServiceID(int serviceID) {
        this.serviceID = serviceID;
    }

     public abstract float request( IProvider provider);
}
