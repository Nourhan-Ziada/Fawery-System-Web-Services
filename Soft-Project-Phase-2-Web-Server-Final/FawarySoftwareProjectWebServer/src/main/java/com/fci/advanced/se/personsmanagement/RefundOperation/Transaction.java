package com.fci.advanced.se.personsmanagement.RefundOperation;

import com.fci.advanced.se.personsmanagement.Service_Package.Service;
public class Transaction {
    private   int transactionId = 0;
    private Service service ;
    private  float totalCost ;

    public Transaction(Service service, float totalCost) {
        this.service = service;
        this.totalCost = totalCost;
        transactionId++ ;
    }

   public int getTransactionId() {
        return transactionId;
    }
    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }
    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public float getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(float totalCost) {
        this.totalCost = totalCost;
    }


}
