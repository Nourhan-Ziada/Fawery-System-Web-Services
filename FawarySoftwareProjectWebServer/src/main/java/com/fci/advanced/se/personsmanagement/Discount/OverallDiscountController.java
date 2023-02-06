package com.fci.advanced.se.personsmanagement.Discount;


import com.fci.advanced.se.personsmanagement.Service_Package.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.*;

@RestController
@RequestMapping("/OverallDiscountController")
public class OverallDiscountController {
    private OverallDiscountDecorator overallDiscountObj;
    private ServiceFactory serviceFactory;

    public void setServiceFactory(ServiceFactory serviceFactory) {
        this.serviceFactory = serviceFactory;
    }

    public OverallDiscountDecorator getOverallDiscountObj() {
        return overallDiscountObj;
    }
    public  void setOverallDiscountObj(OverallDiscountDecorator overallDiscountObj) {
        overallDiscountObj = overallDiscountObj;
    }
    @GetMapping("add/{discountValue}/{transactionNumber}")
    public  String addOverallDiscount(@PathVariable("discountValue") float discountValue, @PathVariable("transactionNumber") int transactionNumber) {
        if(ServiceEntity.getServiceMap().size() == 0) {
            AllService allService = new AllService();
            allService.setupService();
        }

        for ( Map.Entry<ServiceType, Service> entry : ServiceEntity.getServiceMap().entrySet()) {
            {
               OverallDiscountDecorator overallDiscountDecorator = new OverallDiscountDecorator(entry.getValue(), discountValue, transactionNumber);
                overallDiscountDecorator.setServiceName(entry.getKey());
                ServiceEntity.addService(overallDiscountDecorator);
            }

        }
        //try singleton
        Set<String> allDiscounts = new HashSet<>();
        DiscountedServices discounts = DiscountedServices.getInstance(allDiscounts);
        discounts.getAllDiscounts().add("ALL");

        return  "Discount added successfully";
    }
//    public Service checkOverallDiscountForUser(User user, Service service) {
//        if (user.getUserHistory() != null) {
//            int num = user.getUserHistory().searchForNumberTransactionService(service);
//
//        }
//
//    }
}



