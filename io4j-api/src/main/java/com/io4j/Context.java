package com.io4j;


import com.io4j.exception.PlatformResolutionException;

import java.util.Collection;


public interface Context extends ProviderContainer {

    // --------------------------------
    // PLATFORM
    // --------------------------------

    public <PLATFORM_TYPE extends Platform> PLATFORM_TYPE getPlatform() throws PlatformResolutionException;
    public void setPlatform(Platform platform);
    public void setPlatform(Class<? extends Platform> platformClass) throws PlatformResolutionException;
    public void setPlatform(String platformName) throws PlatformResolutionException;
    public Platform platform() throws PlatformResolutionException;
    public Platform platform(Platform platform) throws PlatformResolutionException;
    public Platform platform(Class<? extends Platform> platformClass) throws PlatformResolutionException;
    public Platform platform(String platformName) throws PlatformResolutionException;

    // --------------------------------
    // EXPANDERS
    // --------------------------------

    boolean hasExpander();
    boolean hasExpander(String name);
    boolean hasExpanders(String... name);

    Expander expander(String name);
    <P extends Expander> P expander(String name, Class<P> type);
    Collection<Expander> expanders();
    Collection<Expander> expanders(String... name);
}
