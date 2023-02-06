package com.fci.advanced.se.personsmanagement.ProviderEntity;

import java.util.List;

public interface ProviderFactory {
    public IProvider createProvider(List<String> providers);
}
