package com.io4j;


import com.io4j.exception.PlatformResolutionException;
import com.io4j.io.Pin;
import com.io4j.io.Signal;
import com.io4j.io.gpio.DigitalIOPin;
import com.io4j.io.gpio.GpioProvider;

public class GPIOPin implements DigitalIOPin {

    protected final GpioProvider provider;
    protected final DigitalIOPin pin;


    public GPIOPin(int pinNumber) throws PlatformResolutionException {
        Context context = IO4J.instance();
        this.provider = context.provider(GpioProvider.class);
        this.pin = this.provider.pin(pinNumber);
    }

    public GPIOPin(String pinName) throws PlatformResolutionException {
        Context context = IO4J.instance();
        this.provider = context.provider(GpioProvider.class);
        this.pin = this.provider.pin(pinName);
    }

    public GPIOPin(GpioProvider provider, int pinNumber){
        this.provider = provider;
        this.pin = this.provider.pin(pinNumber);
    }

    public GPIOPin(GpioProvider provider, String pinName){
        this.provider = provider;
        this.pin = this.provider.pin(pinName);
    }

    @Override
    public Signal value() {
        return pin.value();
    }

    @Override
    public boolean isHigh() {
        return pin.isHigh();
    }

    @Override
    public boolean isLow() {
        return pin.isLow();
    }

    @Override
    public DigitalIOPin high() {
        pin.high();
        return this;
    }

    @Override
    public DigitalIOPin low() {
        pin.low();
        return this;
    }

    @Override
    public DigitalIOPin value(boolean high) {
        pin.value(high);
        return this;
    }

    @Override
    public DigitalIOPin value(Signal value) {
        pin.value(value);
        return this;
    }

    @Override
    public <P extends Pin> P as(Class<P> type) {
        return type.cast(this);
    }

    @Override
    public String name() {
        return pin.name();
    }

    @Override
    public int number() {
        return pin.number();
    }
}
