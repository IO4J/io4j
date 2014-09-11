package com.io4j.raspi.io.gpio;

import com.io4j.io.Signal;
import com.io4j.io.gpio.AbstractDigitalIOPin;

public class RaspiGpioPin extends AbstractDigitalIOPin {

    protected Signal value;

    public RaspiGpioPin(int number, String name) {
        super(number, name);
    }

    @Override
    public Signal value() {
        return value;
    }

    @Override
    public RaspiGpioPin value(Signal value) {
        this.value = value;
        return this;
    }

}

