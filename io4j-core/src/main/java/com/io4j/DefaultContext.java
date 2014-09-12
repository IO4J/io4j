package com.io4j;


import com.io4j.exception.PlatformResolutionException;

import java.util.*;

public class DefaultContext implements Context {

    protected Platform platform = null;
    protected Map<String, Extender> expanders = new HashMap<>();

    @Override
    public String toString(){
        return String.format("[<%s>]", this.getClass().getName());
    }

    // --------------------------------
    // PLATFORM
    // --------------------------------

    public Platform getPlatform() throws PlatformResolutionException{
        if(this.platform != null){
            return this.platform;
        }
        // set internal platform instance
        setPlatform(detectPlatform(null, null));
        return this.platform;
    }

    public void setPlatform(Platform platform){
        // set internal platform instance
        this.platform = platform.context(this);
    }

    public void setPlatform(Class<? extends Platform> platformClass) throws PlatformResolutionException {
        // set internal platform instance
        setPlatform(detectPlatform(platformClass, null));
    }

    public void setPlatform(String platformName) throws PlatformResolutionException {
        // set internal platform instance
        setPlatform(detectPlatform(null, platformName));
    }

    public Platform platform() throws PlatformResolutionException {
        return getPlatform();
    }

    public Platform platform(Platform platform) throws PlatformResolutionException {
        // set internal platform instance
        setPlatform(platform);
        return this.platform;
    }

    public Platform platform(Class<? extends Platform> platformClass) throws PlatformResolutionException{
        // set internal platform instance
        setPlatform(platformClass);
        return this.platform;
    }

    public Platform platform(String platformName) throws PlatformResolutionException{
        // set internal platform instance
        setPlatform(platformName);
        return this.platform;
    }

    protected Platform detectPlatform(Class<? extends Platform> platformClass, String platformName) throws PlatformResolutionException {
        Platform result = null;

        // load platforms from service loader
        try {
            ServiceLoader<Platform> loader = ServiceLoader.load(Platform.class);
            for (Platform platform : loader) {

                // handle platform class filter
                if(platformClass != null){
                    if(!platformClass.isInstance(platform)){
                        continue;
                    }
                }

                // handle platform name filter
                if(platformName != null){
                    if(!platformName.equals(platform.name())){
                        continue;
                    }
                }

                // ensure platform is supported on this runtime
                if(platform.isCompatible(this)) {
                    if(result == null){
                        result = platform;
                    }
                    else {
                        // compare platforms weighting
                        if (platform.weight() > result.weight()){
                            result = platform;
                        }
                        else if (platform.weight() == result.weight()){
                            throw new PlatformResolutionException("Ambiguous platform detected; More than one platform service of the same weight was detected on the class path.");
                        }
                    }
                }
            }
        }
        catch(ServiceConfigurationError e){
            throw new PlatformResolutionException("Error encountered while trying to load platform service: " + e.getMessage(), e);
        }

        // validate result
        if(result == null)
            throw new PlatformResolutionException("A platform service was not found in the class path.");

        // return result
        return result;
    }

    // --------------------------------
    // EXPANDERS
    // --------------------------------

    @Override
    public boolean hasExpander() {
        return !this.expanders.isEmpty();
    }

    @Override
    public boolean hasExpander(String name) {
        return expanders.containsKey(name);
    }

    @Override
    public boolean hasExpanders(String ... name) {
        for(String key : name){
            if(!hasExpander(key)){
                return false;
            }
        }
        return true;
    }

    @Override
    public Collection<Extender> expanders(){
        return expanders.values();
    }

    @Override
    public Collection<Extender> expanders(String ... name){
        ArrayList<Extender> results = new ArrayList<>();
        for(String key: name){
            if(expanders.containsKey(key)){
                results.add(expanders.get(key));
            }
        }
        return results;
    }

    @Override
    public Extender expander(String name) {
        return expanders.get(name);
    }

    @Override
    public <P extends Extender> P expander(String name, Class<P> type) {
        if (expanders.containsKey(name)) {
            return type.cast(expanders.get(name));
        }
        return null;
    }

    // --------------------------------
    // PROVIDERS
    // --------------------------------

    @Override
    public boolean hasProviders() throws PlatformResolutionException {
        // ensure a platform is detected
        if(platform == null) getPlatform();

        // first attempt to resolve providers from platform
        if(platform != null && platform.hasProviders()){
            return true;
        }

        // if not found in platform providers, then
        // attempt to resolve providers from expanders
        if(expanders != null && !expanders.isEmpty()){
            for(Extender expander : expanders.values()){
                if(expander.hasProviders()){
                    return true;
                }
            }
        }

        // no providers found
        return false;
    }

    @Override
    public boolean hasProvider(String name) throws PlatformResolutionException {
        // ensure a platform is detected
        if(platform == null) getPlatform();

        // first attempt to resolve named provider from platform
        if(platform != null && platform.hasProvider(name)){
            return true;
        }

        // if not found in platform providers, then
        // attempt to resolve named provider from expanders
        if(expanders != null && !expanders.isEmpty()){
            for(Extender expander : expanders.values()){
                if(expander.hasProvider(name)){
                    return true;
                }
            }
        }

        // no provider by that name found
        return false;
    }

    @Override
    public <PROVIDER_TYPE extends Provider> boolean hasProvider(Class<PROVIDER_TYPE> type) throws PlatformResolutionException {

        // ensure a platform is detected
        if(platform == null) getPlatform();

        // first attempt to resolve provider from platform by class/interface
        if(platform != null && platform.hasProvider(type)){
            return true;
        }

        // if not found in platform providers, then
        // attempt to resolve provider by class/interface from expanders
        if(expanders != null && !expanders.isEmpty()){
            for(Extender expander : expanders.values()){
                if(expander.hasProvider(type)){
                    return true;
                }
            }
        }

        // no provider found with that class/interface type
        return false;
    }

    @Override
    public boolean hasProviders(String ... name) throws PlatformResolutionException {
        for(String key: name){
            if(!hasProvider(key)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public <PROVIDER_TYPE extends Provider> boolean hasProviders(Class<PROVIDER_TYPE> ... type) throws PlatformResolutionException {
        for(Class<PROVIDER_TYPE> typ : type){
            if(!hasProvider(typ)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public <PROVIDER_TYPE extends Provider> PROVIDER_TYPE provider(String name) throws PlatformResolutionException {

        // ensure a platform is detected
        if(platform == null) getPlatform();

        // first attempt to resolve named provider from platform
        if(platform != null && platform.hasProvider(name)){
            return (PROVIDER_TYPE)platform.provider(name);
        }

        // if not found in platform providers, then
        // attempt to resolve named provider from expanders
        if(expanders != null && !expanders.isEmpty()){
            for(Extender expander : expanders.values()){
                if(expander.hasProvider(name)){
                    return (PROVIDER_TYPE)expander.provider(name);
                }
            }
        }

        // no provider by that name found
        return null;
    }

    @Override
    public <PROVIDER_TYPE extends Provider> PROVIDER_TYPE provider(String name, Class<PROVIDER_TYPE> type) throws PlatformResolutionException {

        // ensure a platform is detected
        if(platform == null) getPlatform();

        // first attempt to resolve named provider from platform
        if(platform != null && platform.hasProvider(name)){
            return platform.provider(name, type);
        }

        // if not found in platform providers, then
        // attempt to resolve named provider from expanders
        if(expanders != null && !expanders.isEmpty()){
            for(Extender expander : expanders.values()){
                if(expander.hasProvider(name)){
                    return expander.provider(name, type);
                }
            }
        }

        // no provider by that name found
        return null;
    }

    @Override
    public <PROVIDER_TYPE extends Provider> PROVIDER_TYPE provider(Class<PROVIDER_TYPE> type) throws PlatformResolutionException {
        PROVIDER_TYPE result = null;

        // ensure a platform is detected
        if(platform == null) getPlatform();

        // first attempt to resolve named provider from platform
        if(platform != null){
           result = platform.provider(type);
           if(result != null) return result;
        }

        // if not found in platform providers, then
        // attempt to resolve named provider from expanders
        if(expanders != null && !expanders.isEmpty()){
            for(Extender expander : expanders.values()){
                result = expander.provider(type);
                if(result != null) return result;
            }
        }
        return null;
    }

    @Override
    public Collection<Provider> providers() throws PlatformResolutionException {
        List<Provider> results = new ArrayList<>();

        // ensure a platform is detected
        if(platform == null) getPlatform();

        // first attempt to include platform providers
        if(platform != null){
            results.addAll(platform.providers());
        }

        // next, attempt to include expander providers
        if(expanders != null && !expanders.isEmpty()){
            for(Extender expander : expanders.values()){
                results.addAll(expander.providers());
            }
        }
        return results;
    }

    @Override
    public Collection<Provider> providers(String ... name) throws PlatformResolutionException {
        List<Provider> results = new ArrayList<>();

        // ensure a platform is detected
        if(platform == null) getPlatform();

        // first attempt to include platform providers
        if(platform != null){
            results.addAll(platform.providers(name));
        }

        // next, attempt to include expander providers
        if(expanders != null && !expanders.isEmpty()){
            for(Extender expander : expanders.values()){
                results.addAll(expander.providers(name));
            }
        }
        return results;
    }

    @Override
    public <PROVIDER_TYPE extends Provider> Collection<PROVIDER_TYPE> providers(Class<PROVIDER_TYPE> type) throws PlatformResolutionException {
        List<PROVIDER_TYPE> results = new ArrayList<>();

        // ensure a platform is detected
        if(platform == null) getPlatform();

        // first attempt to include platform providers
        if(platform != null){
            results.addAll(platform.providers(type));
        }

        // next, attempt to include expander providers
        if(expanders != null && !expanders.isEmpty()){
            for(Extender expander : expanders.values()){
                results.addAll(expander.providers(type));
            }
        }
        return results;
    }
}
