package com.fci.advanced.se.personsmanagement.Service_Package;
import com.fci.advanced.se.personsmanagement.ProviderEntity.*;
import com.fci.advanced.se.personsmanagement.User.Response;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.fci.advanced.se.personsmanagement.Service_Package.ServiceType.*;

@RestController
@RequestMapping("/ServiceController")
public class ServiceController {
    public static Service service;
    public static float totalCost;
    public ServiceController(){};
    public float callService(ServiceType serviceType, IProvider provider)
    {
        if(ServiceEntity.getServiceMap().size() == 0) {
            AllService allService = new AllService();
            allService.setupService();
        }
         service = ServiceEntity.searchForService(serviceType);
        totalCost = service.request(provider);
        return totalCost;
    }
    @RequestMapping(value = "/MobileRecharge", method = RequestMethod.GET)

    public Response<Service> callMobileRechargeService(@RequestParam List<String> providers)
    {
        ProviderFactory providerMobileCreator = new ProviderMobileCreator();
        IProvider provider =  providerMobileCreator.createProvider(providers);
        return getServiceResponse(provider, MobileRecharge);
    }
    @RequestMapping(value = "/Internet", method = RequestMethod.GET)

    public Response<Service> callInternetService(@RequestParam List<String> providers)
    {
        ProviderFactory ProviderInternetCreator = new ProviderInternetCreator();
        IProvider provider =  ProviderInternetCreator.createProvider(providers);
        return getServiceResponse(provider, InternetPayment);
    }
    @RequestMapping(value = "/LandLine", method = RequestMethod.GET)

    public Response<Service> callLandLineService(@RequestParam List<String> providers)
    {
        ProviderFactory providerLandLineCreator = new ProviderLandLineCreator();
        IProvider provider =  providerLandLineCreator.createProvider(providers);
        return getServiceResponse(provider, Landline);
    }
    @RequestMapping(value = "/Donation", method = RequestMethod.GET)
    public Response<Service> callDonationService(@RequestParam List<String> providers)
    {
        ProviderFactory  donationCreator= new ProviderDonationCreator();
        IProvider provider =  donationCreator.createProvider(providers);
        return getServiceResponse(provider, Donation);
    }
    private Response<Service> getServiceResponse(IProvider provider, ServiceType serviceType) {
        totalCost = callService(serviceType, provider);
        Response<Service> response = new Response<Service>();
        response.setStatus(true);
        response.setMessage("Total cost Calculated "+ Float.toString(totalCost));
        response.object =  service;
        return response;
    }
}
