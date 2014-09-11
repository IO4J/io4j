package com.io4j;

import java.util.*;

public abstract class AbstractProviderContainer implements ProviderContainer {

    protected Map<String, Provider> providers = new HashMap<>();

    public AbstractProviderContainer(){
    }

    public void addProvider(Provider provider) {

        // add to providers cache
        if(!providers.containsKey(provider.name())){
            providers.put(provider.name(), provider);
        }
    }

    @Override
    public boolean hasProvider(String name){
        return providers.containsKey(name);
    }

    @Override
    public <PROVIDER_TYPE extends Provider> boolean hasProvider(Class<PROVIDER_TYPE> type){
        for(Provider p : providers.values()){
            if(type.isInstance(p)){
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean hasProviders() {
        return !providers().isEmpty();
    }

    @Override
    public boolean hasProviders(String ... name){
        for(String key: name){
            if(!hasProvider(key)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public <PROVIDER_TYPE extends Provider> boolean hasProviders(Class<PROVIDER_TYPE> ... type){
        for(Class<PROVIDER_TYPE> typ : type){
            if(!hasProvider(typ)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public <PROVIDER_TYPE extends Provider> PROVIDER_TYPE provider(String name){
        return (PROVIDER_TYPE)providers.get(name);
    }

    @Override
    public <PROVIDER_TYPE extends Provider> PROVIDER_TYPE provider(String name, Class<PROVIDER_TYPE> type){
        if(providers.containsKey(name)){
            return type.cast(providers.get(name));
        }
        return null;
    }

    @Override
    public <PROVIDER_TYPE extends Provider> PROVIDER_TYPE provider(Class<PROVIDER_TYPE> type){
        for(Provider p : providers.values()){
            if(type.isInstance(p)){
                return type.cast(p);
            }
        }
        return null;
    }

    @Override
    public Collection<Provider> providers(){
        return providers.values();
    }

    @Override
    public Collection<Provider> providers(String ... name){
        List<Provider> results = new ArrayList<>();
        for(String key: name){
            if(providers.containsKey(key)){
                results.add(providers.get(key));
            }
        }
        return results;
    }

    @Override
    public <PROVIDER_TYPE extends Provider> Collection<PROVIDER_TYPE> providers(Class<PROVIDER_TYPE> type) {
        List<PROVIDER_TYPE> results = new ArrayList<>();
        for(Provider provider: providers.values()){
            if(type.isInstance(provider)){
                results.add(type.cast(provider));
            }
        }
        return results;
    }
}
