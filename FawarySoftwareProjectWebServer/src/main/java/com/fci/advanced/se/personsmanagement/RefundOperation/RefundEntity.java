package com.fci.advanced.se.personsmanagement.RefundOperation;
import com.fci.advanced.se.personsmanagement.User.User;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;
public  class RefundEntity {
    private static RefundEntity refundEntity;
    private static Map<User, Vector<Transaction>> mapRequestRefund = new HashMap<User, Vector<Transaction>>();
    private Map<User, Transaction> mapaccapetRefund = new HashMap<User, Transaction>();

    private RefundEntity(Map<User, Vector<Transaction>> mapRequestRefund) {
        this.mapRequestRefund = mapRequestRefund;
    }

    public static Map<User, Vector<Transaction>> getMapRequestRefund() {
        return mapRequestRefund;
    }

    public static void setMapRequestRefund(Map<User, Vector<Transaction>> mapRequestRefund) {

        RefundEntity.mapRequestRefund = mapRequestRefund;
    }
    public static void addRefund(User user, Transaction transaction) {

        for (Map.Entry<User, Vector<Transaction>> entry : mapRequestRefund.entrySet()) {
            if (mapRequestRefund.containsKey(user)) {

                entry.getValue().add(transaction);
            } else {
                Vector<Transaction> vector = new Vector<>();
                vector.add(transaction);
                mapRequestRefund.put(user, vector);
            }
        }
    }
    public static void removeRefund(User user, Transaction transaction) {
        for (Map.Entry<User, Vector<Transaction>> entry : mapRequestRefund.entrySet()) {
            if (mapRequestRefund.containsKey(user)) {
                Vector<Transaction> transactions = entry.getValue();
                for (int j = 0; j < transactions.size(); j++) {
                    Transaction transaction1 = entry.getValue().get(j);
                    if (transaction1 == transaction)
                        entry.getValue().remove(transaction);
                }
            }
        }
    }

    public static RefundEntity getInstance(Map<User,Vector< Transaction>> mapRequestRefund)
    {
        if(refundEntity == null) {
            refundEntity = new RefundEntity(mapRequestRefund);
        }

        return refundEntity ;
    }

}