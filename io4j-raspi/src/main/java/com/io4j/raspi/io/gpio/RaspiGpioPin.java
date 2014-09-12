package com.io4j.raspi.io.gpio;

import com.io4j.io.Signal;
import com.io4j.io.gpio.AbstractDigitalOutput;

public class RaspiGpioPin extends AbstractDigitalOutput {

    public RaspiGpioPin(int number, String name) {
        super(number, name);
    }

    @Override
    public RaspiGpioPin value(Signal value) {
        this.value = value;
        return this;
    }
}

