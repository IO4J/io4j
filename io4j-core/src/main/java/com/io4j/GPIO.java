package com.io4j;


import com.io4j.exception.PlatformResolutionException;
import com.io4j.io.Pin;
import com.io4j.io.gpio.DigitalPin;
import com.io4j.io.gpio.GpioProvider;

import java.util.Collection;

public class GPIO {

    protected final GpioProvider provider;


    public GPIO() throws PlatformResolutionException {
        Context context = IO4J.instance();
        this.provider = context.provider(GpioProvider.class);
    }

    public GPIO(GpioProvider provider){
        this.provider = provider;
    }

    public Collection<Pin> pins() {
        return provider.pins();
    }

    public Collection<Pin> pins(String... name) {
        return provider.pins(name);
    }

    public Collection<Pin> pins(int... number) {
        return provider.pins(number);
    }

    public boolean hasPin(int number) {
        return provider.hasPin(number);
    }

    public boolean hasPin(String name) {
        return provider.hasPin(name);
    }

    public boolean hasPins(int... number) {
        return provider.hasPins(number);
    }

    public boolean hasPins(String... name) {
        return provider.hasPins(name);
    }

    public <PIN_TYPE extends DigitalPin> PIN_TYPE pin(int number) {
        return provider.pin(number);
    }

    public <PIN_TYPE extends DigitalPin> PIN_TYPE pin(int number, Class<PIN_TYPE> type) {
        return provider.pin(number, type);
    }

    public <PIN_TYPE extends DigitalPin> PIN_TYPE pin(String name) {
        return provider.pin(name);
    }

    public <PIN_TYPE extends DigitalPin> PIN_TYPE pin(String name, Class<PIN_TYPE> type) {
        return provider.pin(name, type);
    }
}
