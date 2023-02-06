package com.fci.advanced.se.personsmanagement.FormHandler;

public interface HandlerFactory {
    public IHandler create(String handlerName);
}
