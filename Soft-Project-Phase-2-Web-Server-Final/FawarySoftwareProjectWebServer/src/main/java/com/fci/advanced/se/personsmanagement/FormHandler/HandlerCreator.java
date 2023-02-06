package com.fci.advanced.se.personsmanagement.FormHandler;

import com.fci.advanced.se.personsmanagement.FormHandler.Internet.EtisalatInternetHandler;
import com.fci.advanced.se.personsmanagement.FormHandler.Internet.OrangeInternetHandler;
import com.fci.advanced.se.personsmanagement.FormHandler.Internet.VodafoneInternetHandler;
import com.fci.advanced.se.personsmanagement.FormHandler.Internet.WeInternetHandler;
import com.fci.advanced.se.personsmanagement.FormHandler.Mobile.EtisalatMobileHandler;
import com.fci.advanced.se.personsmanagement.FormHandler.Mobile.OrangeMobileHandler;
import com.fci.advanced.se.personsmanagement.FormHandler.Mobile.VodafoneMobileHandler;
import com.fci.advanced.se.personsmanagement.FormHandler.Mobile.WeMobileHandler;

import java.util.Objects;

public class HandlerCreator implements HandlerFactory{
    @Override
    public IHandler create(String handlerName) {
        if(Objects.equals(handlerName, "EtisalatInternetHandler"))
            return (new EtisalatInternetHandler());
        if(Objects.equals(handlerName, "OrangeInternetHandler"))
            return (new OrangeInternetHandler());
        if(Objects.equals(handlerName, "VodafoneInternetHandler"))
            return new VodafoneInternetHandler();
        if(Objects.equals(handlerName, "WeInternetHandler"))
            return new WeInternetHandler();
        if(Objects.equals(handlerName, "EtisalatMobileHandler"))
            return new EtisalatMobileHandler();
        if(Objects.equals(handlerName, "OrangeMobileHandler"))
            return new OrangeMobileHandler();
        if(Objects.equals(handlerName, "VodafoneMobileHandler"))
            return new VodafoneMobileHandler();
        if(Objects.equals(handlerName, "WeMobileHandler"))
            return new WeMobileHandler();
        if(Objects.equals(handlerName, "DonationHandler"))
            return new DonationHandler();
        if(Objects.equals(handlerName, "TelecomEgyptHandler"))
            return new TelecomEgyptHandler();
        return null;
    }
}
