package com.fci.advanced.se.personsmanagement.PaymentMethod_Package;

import com.fci.advanced.se.personsmanagement.User.User;

public class WalletPayment implements Payment{
    @Override
    public float pay(User user, float totalCost) {
        if(user.getWallet().getBalance() >= totalCost)
        {
            user.getWallet().consumeMoney(totalCost);
            //return totalCost
            return (user.getWallet().getBalance());
        }
       return -1;
    }
}
