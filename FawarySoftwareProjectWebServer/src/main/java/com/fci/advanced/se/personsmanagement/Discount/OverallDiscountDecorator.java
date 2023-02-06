package com.fci.advanced.se.personsmanagement.Discount;


import com.fci.advanced.se.personsmanagement.ProviderEntity.IProvider;
import com.fci.advanced.se.personsmanagement.Service_Package.Service;

public class OverallDiscountDecorator extends ServiceDecorator {
   private boolean overallDiscount = true ;
   private int discounttransactionNumber ;

    public boolean isOverallDiscount() {
        return overallDiscount;
    }

    public void setOverallDiscount(boolean overallDiscount) {
        this.overallDiscount = overallDiscount;
    }

    public int getDiscounttransactionNumber() {
        return discounttransactionNumber;
    }

    public void setDiscounttransactionNumber(int discounttransactionNumber) {
        this.discounttransactionNumber = discounttransactionNumber;
    }

    public OverallDiscountDecorator(Service service , float discountValue , int discounttransactionNumber) {
        super(service);
        this.discounttransactionNumber = discounttransactionNumber;
        super.discountValue = discountValue ;
        this.discounttransactionNumber = discounttransactionNumber ;

    }

    @Override
    public float request(IProvider provider) {
        if(overallDiscount) {
            float cost = service.request(provider);
            return cost * (1 - discountValue) ;

        }
        return service.request(provider) ;
    }
}
