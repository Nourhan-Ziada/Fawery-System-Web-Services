package com.fci.advanced.se.personsmanagement.Discount;


import com.fci.advanced.se.personsmanagement.Service_Package.*;
import com.fci.advanced.se.personsmanagement.User.Response;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/SpecificDiscountController")
public class SpecificDiscountController {

    private ServiceFactory serviceFactory;

    public void setServiceFactory(ServiceFactory serviceFactory) {
        this.serviceFactory = serviceFactory;
    }

    public SpecificDiscountController(){}


    @GetMapping("add/{serviceName}/{discountValue}")
    public  Response callAddSpecificDiscount(@PathVariable("serviceName") ServiceType serviceName,@PathVariable("discountValue") float discountValue) {
        Response response = new Response();
        response.setStatus(true);
        response.setMessage("Discount added successfully");
        Service service = addSpecificDiscount(serviceName,discountValue);
        response.object = service;
        return response;
    }
    public Service addSpecificDiscount(ServiceType serviceName,float discountValue) {
        if(ServiceEntity.getServiceMap().size() == 0) {
            AllService allService = new AllService();
            allService.setupService();
        }
            Set<String> allDiscounts = new HashSet<>();
            DiscountedServices discounts = DiscountedServices.getInstance(allDiscounts);
            Service service = ServiceEntity.searchForService(serviceName);
            SpecificDiscountDecorator specificDiscountDecorator = new SpecificDiscountDecorator(service, discountValue);
            specificDiscountDecorator.setServiceName(serviceName);
            ServiceEntity.addService(specificDiscountDecorator);
            ServiceEntity.searchForService(serviceName);
            discounts.getAllDiscounts().add(serviceName.toString());
            return ServiceEntity.searchForService(serviceName);
        }
}

