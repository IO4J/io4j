package com.io4j.raspi.test;


import com.io4j.Context;
import com.io4j.IO4J;
import com.io4j.Provider;
import com.io4j.exception.PlatformResolutionException;
import com.io4j.io.gpio.GpioProvider;
import com.io4j.raspi.io.gpio.RaspiGpioProvider;
import com.io4j.raspi.RaspiPlatform;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RaspiPlatformTests {

    private static Context io4j;

    @BeforeClass
    public static void beforeAllTests() throws PlatformResolutionException {
        io4j = IO4J.newInstance(RaspiPlatform.class);
    }

    @Test
    public void testPlatformEquals() throws Exception {
        System.out.println("[PLATFORM] " + io4j.platform());
        assertEquals(new RaspiPlatform(), io4j.platform());
    }

    @Test
    public void testPlatformNameEquals() throws Exception {
        System.out.println("[PLATFORM NAME] " + io4j.platform().name());
        assertEquals(RaspiPlatform.NAME, io4j.platform().name());
    }

    @Test
    public void testProvidersCount() throws Exception {
        for(Provider provider : io4j.platform().providers()){
            System.out.println("[PROVIDER NAME] " + provider.name());
        }
        assertEquals(4, io4j.platform().providers().size());
    }

    @Test
    public void testGetGpioProviderByName() throws Exception {
        RaspiGpioProvider provider = io4j.platform().provider(RaspiGpioProvider.PROVIDER_NAME);
        assertEquals(RaspiGpioProvider.PROVIDER_NAME, provider.name());
    }

    @Test
    public void testGetGpioProviderByClass() throws Exception {
        GpioProvider provider = io4j.platform().provider(GpioProvider.class);
        assertEquals(RaspiGpioProvider.PROVIDER_NAME, provider.name());
    }

    @Test
    public void testGetGpioProviderByNameAndClass() throws Exception {
        GpioProvider provider = io4j.platform().provider(RaspiGpioProvider.PROVIDER_NAME, GpioProvider.class);
        assertEquals(RaspiGpioProvider.PROVIDER_NAME, provider.name());
    }

    @Test
    public void testGpioPinCount() throws Exception {

        GpioProvider provider = io4j.platform().provider(RaspiGpioProvider.PROVIDER_NAME).as(GpioProvider.class);
        System.out.println("[GPIO PIN COUNT] " + provider.pins().size());
        assertEquals(RaspiGpioProvider.PIN_COUNT, provider.pins().size());
    }

}
