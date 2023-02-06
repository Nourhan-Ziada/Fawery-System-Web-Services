package com.fci.advanced.se.personsmanagement.Service_Package;
import com.fci.advanced.se.personsmanagement.Service_Package.Service;
import com.fci.advanced.se.personsmanagement.Service_Package.ServiceType;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Vector;
public class ServiceEntity {
    private static Map<ServiceType, Service> serviceMap = new HashMap<>();

    public static Map<ServiceType, Service> getServiceMap() {return serviceMap; }

    public static void addService(Service service){
        serviceMap.put(service.getServiceName(), service);
    }
    public static void deleteService(Service service) {
        serviceMap.remove(service.getServiceName(), service);

    }
    public static Service searchForService(ServiceType serviceName) //return Service
    {
        for (Map.Entry<ServiceType,Service> entry :serviceMap.entrySet()) {

            if (serviceMap.isEmpty())
                return null ;

            else if (Objects.equals(entry.getValue().getServiceName(), serviceName)) {
                return entry.getValue() ;
            }
        }
        return null;
    }
    public static void removeService(Service service) {
        serviceMap.remove(service.getServiceName(), service);

    }
    public static Vector<String> searchService(String userSearch)
    {
        Vector<String>serviceName = new Vector<>();
       for (ServiceType serviceType : ServiceType.values())
       {
           if (Character.toUpperCase(userSearch.charAt(0) ) ==  serviceType.toString().charAt(0))
               serviceName.add(serviceType.toString());
       }
       return serviceName;
    }
}
