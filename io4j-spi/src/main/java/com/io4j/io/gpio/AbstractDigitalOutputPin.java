package com.io4j.io.gpio;

import com.io4j.io.AbstractPin;
import com.io4j.io.Signal;

public abstract class AbstractDigitalOutputPin
        extends AbstractPin<DigitalOutputPin>
            implements DigitalOutputPin<DigitalOutputPin> {

    public AbstractDigitalOutputPin(int number, String name) {
        super(number, name);
    }

    @Override
    public DigitalOutputPin high() {
        return value(Signal.High);
    }

    @Override
    public DigitalOutputPin low() {
        return value(Signal.Low);
    }

    @Override
    public DigitalOutputPin value(boolean high){
        return value( high ? Signal.High : Signal.Low );
    }

    @Override
    public abstract DigitalOutputPin value(Signal value);
}
