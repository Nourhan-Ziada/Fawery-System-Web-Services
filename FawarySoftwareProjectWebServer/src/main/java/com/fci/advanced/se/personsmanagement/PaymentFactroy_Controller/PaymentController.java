package com.fci.advanced.se.personsmanagement.PaymentFactroy_Controller;
import com.fci.advanced.se.personsmanagement.TransactionDatabase.StructTransaction;
import com.fci.advanced.se.personsmanagement.TransactionDatabase.TransactionDatabase;
import com.fci.advanced.se.personsmanagement.TransactionDatabase.TransactionType;
import com.fci.advanced.se.personsmanagement.PaymentMethod_Package.Payment;
import com.fci.advanced.se.personsmanagement.RefundOperation.Transaction;
import com.fci.advanced.se.personsmanagement.Service_Package.Service;
import com.fci.advanced.se.personsmanagement.Service_Package.ServiceController;
import com.fci.advanced.se.personsmanagement.User.CurrentUser;
import com.fci.advanced.se.personsmanagement.User.Response;
import com.fci.advanced.se.personsmanagement.User.User;
import com.fci.advanced.se.personsmanagement.User.UserHistory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

@RestController
@RequestMapping("/PaymentController")
public class PaymentController {
  private float finalCost;
    public static float callPay(User user , float totalCost, Service service , Payment paymentMethod)
    {
        float cost = paymentMethod.pay(user , totalCost);
        if (cost != -1 )
        {
            Transaction transaction = new Transaction(service,totalCost);
            if(user.getUserHistory() ==null)
            {
                UserHistory userHistory = new UserHistory();
                userHistory.addTransaction(transaction);
                user.setUserHistory(userHistory);
            }
            else
                user.getUserHistory().addTransaction(transaction);
            transaction.setTransactionId(user.getUserHistory().getTransCountForUser());
        }
        return cost;
    }
    @RequestMapping(value = "/Payment", method = RequestMethod.GET)
    public  Response<UserHistory> pay( @RequestParam List<String> paymentData)
    { // I sent user as I need it to pay but when I separate senior I should remove it from req service and call service
        PaymentFactory paymentCreator = new PaymentCreator();
        Payment payment = paymentCreator.createPaymentMethod(paymentData);
        return getTransactionResponse(payment);
    }
    private Response<UserHistory> getTransactionResponse(Payment payment ) {
        User activeUser = CurrentUser.user;
        finalCost = callPay(activeUser, ServiceController.totalCost, ServiceController.service, payment);
        Response<UserHistory> response = new Response<UserHistory>();
        if (finalCost != -1) {
            response.setStatus(true);
            response.setMessage("Total cost Calculated "+ Float.toString(finalCost));
            response.object = activeUser.getUserHistory();
            StructTransaction structTransaction = new StructTransaction(TransactionType.Payment, finalCost);
            if(TransactionDatabase.getTransactionDatabase() == null)
            {
                Map<String, Vector<StructTransaction>> transDatabase = new HashMap<>();
                Vector<StructTransaction> vector = new Vector<>();
                vector.add(structTransaction);
                transDatabase.put(activeUser.getAccount().getUsername(), vector);
                TransactionDatabase.setTransactionDatabase(transDatabase);
            }
            else
                TransactionDatabase.addTransaction(activeUser.getAccount().getUsername(), structTransaction);
        }
        else
        {
            response.setStatus(false);
            response.setMessage("Failed Payment");
            response.object = null;
        }
        return response;

    }
}
