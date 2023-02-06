package com.fci.advanced.se.personsmanagement.User;

import com.fci.advanced.se.personsmanagement.RefundOperation.Transaction;
import com.fci.advanced.se.personsmanagement.Service_Package.Service;

import java.util.HashMap;
import java.util.Map;

public class UserHistory {
    private Map<Integer, Transaction> userMap = new HashMap<Integer, Transaction>();
    private int transCountForUser = 0;

    public int getTransCountForUser() {
        return transCountForUser;
    }

    public  int searchForNumberTransactionService(Service service){
        int counter = 0;
        for (Map.Entry<Integer,Transaction> entry : userMap.entrySet())
        {
            if(entry.getValue().getService() == service)
            {
                counter++;
            }
        }
        return counter ;
    }
    // username numOf trans service
    public void addTransaction(Transaction transaction){
        transCountForUser++;
        userMap.put(transCountForUser,transaction);
    }
    public void removeTransaction(Transaction transaction){
        userMap.remove(transCountForUser,transaction);
    }
    public Transaction searchForTransaction(int transactionId)
    {
            for (Map.Entry<Integer,Transaction> entry : userMap.entrySet()) {
            if (userMap.isEmpty())
                return null;
            else if (entry.getKey() == transactionId) {
                return entry.getValue();
            }
        }
        return null;
    }

}
