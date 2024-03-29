package com.io4j.example;


import com.io4j.Context;
import com.io4j.IO4J;
import com.io4j.Provider;
import com.io4j.exception.PlatformResolutionException;
import com.io4j.io.Signal;
import com.io4j.io.gpio.DigitalOutput;
import com.io4j.io.gpio.GpioProvider;

public class GpioProviderExample {

    public static void main(String ... arguments) throws PlatformResolutionException {

        // create the IO4J context instance
        // ... this will auto detect any available platforms and extenders in the classpath
        Context io4j = IO4J.instance();

        System.out.println("Detected context:  " + io4j);
        System.out.println("Detected platform: " + io4j.platform());

        // get the available platform providers
        for(Provider provider : io4j.platform().providers()){
            System.out.println("Detected platform provider: " + provider.name());
        }

        // get the "default" GPIO provider
        // (NOTE:  platform providers will be returned first before searching for providers in extenders)
        GpioProvider gpioProvider = io4j.provider(GpioProvider.class);


        // create a GPIO I/O pin instance
        DigitalOutput output = gpioProvider.pin(1);

        System.out.println("Detected GPIO pin   : " + output.name());
        System.out.println("Detected GPIO value : " + output.value(Signal.High).value());
        System.out.println("Detected GPIO value : " + output.value(Signal.Low).value());
    }
}
