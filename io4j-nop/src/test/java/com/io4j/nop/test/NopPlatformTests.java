package com.io4j.nop.test;


import com.io4j.IO4J;
import com.io4j.Context;
import com.io4j.exception.PlatformResolutionException;
import com.io4j.nop.NopPlatform;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class NopPlatformTests {

    private static Context io4j;

    @BeforeClass
    public static void beforeAllTests() throws PlatformResolutionException {
        io4j = IO4J.newInstance(NopPlatform.class);
    }

    @Test
    public void testPlatformEquals() throws Exception {
        System.out.println("[PLATFORM] " + io4j.platform());
        assertEquals(new NopPlatform(), io4j.platform());
    }

    @Test
    public void testPlatformNameEquals() throws Exception {
        System.out.println("[PLATFORM NAME] " + io4j.platform().name());
        assertEquals(NopPlatform.NAME, io4j.platform().name());
    }

}
