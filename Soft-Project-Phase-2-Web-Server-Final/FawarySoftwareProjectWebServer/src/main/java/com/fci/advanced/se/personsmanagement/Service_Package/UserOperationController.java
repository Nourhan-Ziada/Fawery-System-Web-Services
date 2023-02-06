package com.fci.advanced.se.personsmanagement.Service_Package;

import com.fci.advanced.se.personsmanagement.Discount.DiscountedServices;
import com.fci.advanced.se.personsmanagement.PaymentMethod_Package.CreditCard;
import com.fci.advanced.se.personsmanagement.TransactionDatabase.StructTransaction;
import com.fci.advanced.se.personsmanagement.TransactionDatabase.TransactionDatabase;
import com.fci.advanced.se.personsmanagement.TransactionDatabase.TransactionType;
import com.fci.advanced.se.personsmanagement.User.CurrentUser;
import com.fci.advanced.se.personsmanagement.User.Wallet;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@RequestMapping("/UserOperationController")
public class UserOperationController {
    @GetMapping("/recharge/{money}/{creditNumber}/{CVV}")
    public Wallet rechargeWallet(@PathVariable("money") Float money,@PathVariable("creditNumber") String creditNumber,@PathVariable("CVV") String CVV){
        return addingMoneyWallet(money,creditNumber,CVV) ;
    }
    @GetMapping("/search/{serviceName}")
    public Vector<String>searchServices(@PathVariable("serviceName") String serviceName){
        return ServiceEntity.searchService(serviceName);
    }
    @GetMapping("/showDiscounts")
    public Set<String> showDiscounts(){
        //try singleton
        Set<String> allDiscounts = new HashSet<>();
        DiscountedServices discounts = DiscountedServices.getInstance(allDiscounts);
        return discounts.getAllDiscounts();
    }
    public Wallet addingMoneyWallet(Float money , String creditNumber , String CVV)
    {
        CreditCard creditCard = new CreditCard(creditNumber,CVV);
        float totalMoney = creditCard.pay( CurrentUser.user ,money);
        CurrentUser.user.getWallet().addMoney(totalMoney);
        StructTransaction structTransaction = new StructTransaction(TransactionType.wallet, totalMoney);
        if(TransactionDatabase.getTransactionDatabase() == null)
        {
            Map<String, Vector<StructTransaction>> transDatabase = new HashMap<>();
            Vector<StructTransaction> vector = new Vector<>();
            vector.add(structTransaction);
            transDatabase.put(CurrentUser.user.getAccount().getUsername(), vector);
            TransactionDatabase.setTransactionDatabase(transDatabase);
        }
        else
            TransactionDatabase.addTransaction(CurrentUser.user.getAccount().getUsername(), structTransaction);
        return  CurrentUser.user.getWallet();
    }


}
