package com.io4j;


import com.io4j.exception.PlatformResolutionException;

import java.util.Collection;

public interface ProviderContainer {

    boolean hasProvider(String name) throws PlatformResolutionException;
    <PROVIDER_TYPE extends Provider> boolean hasProvider(Class<PROVIDER_TYPE> type) throws PlatformResolutionException;
    boolean hasProviders() throws PlatformResolutionException;
    boolean hasProviders(String... name) throws PlatformResolutionException;
    <PROVIDER_TYPE extends Provider> boolean hasProviders(Class<PROVIDER_TYPE> ... type) throws PlatformResolutionException;

    <PROVIDER_TYPE extends Provider> PROVIDER_TYPE provider(String name) throws PlatformResolutionException;
    <PROVIDER_TYPE extends Provider> PROVIDER_TYPE provider(String name, Class<PROVIDER_TYPE> type) throws PlatformResolutionException;
    <PROVIDER_TYPE extends Provider> PROVIDER_TYPE provider(Class<PROVIDER_TYPE> type) throws PlatformResolutionException;

    Collection<Provider> providers() throws PlatformResolutionException;
    Collection<Provider> providers(String... name) throws PlatformResolutionException;
    <PROVIDER_TYPE extends Provider> Collection<PROVIDER_TYPE> providers(Class<PROVIDER_TYPE> type) throws PlatformResolutionException;
}
