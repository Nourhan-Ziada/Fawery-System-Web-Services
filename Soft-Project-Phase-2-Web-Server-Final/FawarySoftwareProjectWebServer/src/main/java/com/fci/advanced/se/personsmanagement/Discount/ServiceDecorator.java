package com.fci.advanced.se.personsmanagement.Discount;


import com.fci.advanced.se.personsmanagement.ProviderEntity.IProvider;
import com.fci.advanced.se.personsmanagement.Service_Package.Service;

public abstract class ServiceDecorator extends Service {
    protected Service service ;
    protected float discountValue ;


    public float getDiscountValue() {
        return discountValue;
    }

    public void setDiscountValue(float discountValue) {
        this.discountValue = discountValue;
    }


    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public ServiceDecorator(Service service) {
        this.service = service;
    }


    @Override
    public abstract float request(IProvider provider);


}
