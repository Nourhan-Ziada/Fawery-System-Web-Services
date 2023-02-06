package com.fci.advanced.se.personsmanagement.RefundOperation;

import com.fci.advanced.se.personsmanagement.Service_Package.ServiceType;
import com.fci.advanced.se.personsmanagement.TransactionDatabase.StructTransaction;
import com.fci.advanced.se.personsmanagement.TransactionDatabase.TransactionDatabase;
import com.fci.advanced.se.personsmanagement.TransactionDatabase.TransactionType;
import com.fci.advanced.se.personsmanagement.User.CurrentUser;
import com.fci.advanced.se.personsmanagement.User.User;
import com.fci.advanced.se.personsmanagement.User.UserEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@RequestMapping("/RefundController")
public class RefundController {
  private static String text  ;

    @GetMapping("/get/{transactionId}/{serviceName}")
    public String reqRefund(@PathVariable("transactionId") int transactionId , @PathVariable("serviceName") ServiceType serviceType) {

        return RefundRequest(transactionId ,serviceType);
    }
    @GetMapping("/showRefunds")
    public Map<String,Vector<Transaction>> ShowRefunds() {
         Map<String, Vector<Transaction>> myRefunds = new HashMap<String, Vector<Transaction>>();
        for (Map.Entry<User,Vector<Transaction>> entry : RefundEntity.getMapRequestRefund().entrySet()) {
            Vector<Transaction> transactions = new Vector<>();
            for (int i = 0; i <entry.getValue().size() ; i++) {
                transactions.add(entry.getValue().get(i));
            }
            myRefunds.put(entry.getKey().getAccount().getUsername(),transactions);
        }
        return myRefunds;
    }
    @GetMapping("/adminRefund/{userName}/{tarnsId}/{reply}")
    public String isAcceptRefund(@PathVariable ("userName") String userName, @PathVariable ("tarnsId") int transID, @PathVariable("reply") int reply)
    {
        User user = UserEntity.searchForUser(userName);
        Transaction transaction = user.getUserHistory().searchForTransaction(transID);
        return replyRequestReFund(reply, transaction, user);
    }
    public String  RefundRequest( int transactionId , ServiceType serviceType) {
        User user = CurrentUser.user;
        RefundEntity refundEntity = null;
        if (user.getUserHistory() == null) {
            return ("There is no History");
        }
        else
        {
            Transaction transaction = user.getUserHistory().searchForTransaction(transactionId);
            if (RefundEntity.getMapRequestRefund().size() == 0) {
                Map<User, Vector<Transaction>> mapRequestRefund = new HashMap<>();
                Vector<Transaction> vector = new Vector<>();
                vector.add(transaction); // transaction may be null
                mapRequestRefund.put(user, vector);
                refundEntity = RefundEntity.getInstance(mapRequestRefund);
                refundTransDataBase(user.getAccount().getUsername(), transaction.getTotalCost());
                return ("Request Map is under processing");
            }
            else if (transaction != null) {
                RefundEntity.addRefund(user, transaction);
                refundTransDataBase(user.getAccount().getUsername(), transaction.getTotalCost());
                return ("Request is under processing");
            }
            else {
                text = " Sorry Request Not Found";
                return text;
            }

        }
    }
   public static String replyRequestReFund(int reply , Transaction transaction ,User user)
   {

       if(reply == 1)
       {
           RefundEntity.removeRefund(user, transaction);
           user.getWallet().addMoney((transaction.getTotalCost()));
           user.getWallet().getBalance();
           user.getUserHistory().removeTransaction(transaction);
           return ( " Balance after = " + user.getWallet().getBalance());
       }
       else
       {
           RefundEntity.removeRefund(user, transaction);
           text = " Sorry Request is Rejected";
           return text;
       }
   }
    public void refundTransDataBase(String userName,float money)
    {
        StructTransaction structTransaction = new StructTransaction(TransactionType.Refund, money);
        if(TransactionDatabase.getTransactionDatabase() == null)
        {
            Map<String, Vector<StructTransaction>> transDatabase = new HashMap<>();
            Vector<StructTransaction> vector = new Vector<>();
            vector.add(structTransaction);
            transDatabase.put(userName, vector);
            TransactionDatabase.setTransactionDatabase(transDatabase);
        }
        else
            TransactionDatabase.addTransaction(userName, structTransaction);
    }
}
