package com.fci.advanced.se.personsmanagement.User;


public class Wallet {
    private float balance ;

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    public  void addMoney( float amount)
    {
        balance += amount ;
    }

    public  void consumeMoney( float amount)
    {
        balance -= amount ;
    }


}
