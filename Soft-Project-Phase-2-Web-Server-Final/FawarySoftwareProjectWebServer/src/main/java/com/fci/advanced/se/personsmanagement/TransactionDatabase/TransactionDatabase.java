package com.fci.advanced.se.personsmanagement.TransactionDatabase;

import java.util.Map;
import java.util.Vector;
public class TransactionDatabase{
    private static Map<String, Vector<StructTransaction>> transactionDatabase;

    public static Map<String, Vector<StructTransaction>> getTransactionDatabase() {
        return transactionDatabase;
    }
    public static void setTransactionDatabase(Map<String, Vector<StructTransaction>> transactionDatabase) {
        TransactionDatabase.transactionDatabase = transactionDatabase;
    }
    public static void addTransaction(String userName, StructTransaction transaction) {
        for (Map.Entry<String, Vector<StructTransaction>> entry : transactionDatabase.entrySet()) {
            if (transactionDatabase.containsKey(userName)) {
                entry.getValue().add(transaction);
            }
            else {
                Vector<StructTransaction> vector = new Vector<>();
                vector.add(transaction);
                transactionDatabase.put(userName, vector);
            }
        }
    }
    public  static void removeTransaction(String userName, StructTransaction transaction) {
        for (Map.Entry<String, Vector<StructTransaction>> entry : transactionDatabase.entrySet()) {
            if (transactionDatabase.containsKey(userName)) {
                Vector<StructTransaction> transactions = entry.getValue();
                for (int j = 0; j < transactions.size(); j++) {
                    StructTransaction transaction1 = entry.getValue().get(j);
                    if (transaction1 == transaction)
                        entry.getValue().remove(transaction);
                }
            }
        }
    }
}
