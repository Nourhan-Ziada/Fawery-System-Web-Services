package com.fci.advanced.se.personsmanagement.Discount;


import com.fci.advanced.se.personsmanagement.ProviderEntity.IProvider;
import com.fci.advanced.se.personsmanagement.Service_Package.Service;

public class SpecificDiscountDecorator extends ServiceDecorator {
    public   boolean SpecificDiscount = false ;

    public boolean isSpecificDiscount() {
        return SpecificDiscount;
    }

    public void setSpecificDiscount(boolean specificDiscount) {
        SpecificDiscount = specificDiscount;
    }
    public SpecificDiscountDecorator(Service service , float discountValue) {
        super(service);
        super.discountValue = discountValue ;
        System.out.println("discountValue " + discountValue);
        SpecificDiscount = true;
    }
    @Override
    public float request( IProvider provider) {

       float cost = service.request(provider);
        return cost * (1 - discountValue) ;
    }
}
