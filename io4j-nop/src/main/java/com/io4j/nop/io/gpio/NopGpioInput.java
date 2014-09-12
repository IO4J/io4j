package com.io4j.nop.io.gpio;

import com.io4j.io.Signal;
import com.io4j.io.gpio.AbstractDigitalInput;

public class NopGpioInput extends AbstractDigitalInput {

    protected Signal value = Signal.Unknown;

    public NopGpioInput(int number, String name) {
        super(number, name);
    }

    @Override
    public Signal value() {
        return value;
    }

}

