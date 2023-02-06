package com.fci.advanced.se.personsmanagement.FormHandler;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/HandlerController")
public class HandlerController {
    @GetMapping("/get/{handlerName}")
    public String callHandler(@PathVariable("handlerName") String handlerName)
    {
        HandlerFactory handlerCreator = new HandlerCreator();
        IHandler handler = handlerCreator.create(handlerName);
        return handler.execute();
    }
}
