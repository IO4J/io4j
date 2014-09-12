package com.io4j.nop.io.gpio;

import com.io4j.io.Signal;
import com.io4j.io.gpio.AbstractDigitalOutput;
import com.io4j.io.gpio.DigitalOutput;

public class NopGpioOutput extends AbstractDigitalOutput {

    public NopGpioOutput(int number, String name) {
        super(number, name);
    }

    @Override
    public DigitalOutput value(Signal value) {
        this.value = value;
        return this;
    }
}

