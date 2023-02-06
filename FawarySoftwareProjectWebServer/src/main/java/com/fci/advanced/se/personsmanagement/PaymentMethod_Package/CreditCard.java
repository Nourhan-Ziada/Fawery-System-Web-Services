package com.fci.advanced.se.personsmanagement.PaymentMethod_Package;

import com.fci.advanced.se.personsmanagement.User.User;

public class CreditCard implements Payment{
public CreditCard(){};
    private  String creditNumber ;
    private   String CVV ;

    public CreditCard(String creditNumber, String CVV) {
        this.creditNumber = creditNumber;
        this.CVV = CVV;
    }

    public void setCreditNumber(String creditNumber) {
        this.creditNumber = creditNumber;
    }
    public void setCVV(String CVV) {
        this.CVV = CVV;
    }

    @Override
    public float pay(User user, float totalCost) { // might be checked for credit number
        return totalCost;
    }
}
