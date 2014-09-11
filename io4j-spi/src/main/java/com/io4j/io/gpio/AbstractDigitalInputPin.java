package com.io4j.io.gpio;

import com.io4j.io.AbstractPin;
import com.io4j.io.Signal;

public abstract class AbstractDigitalInputPin
        extends AbstractPin<DigitalInputPin>
        implements DigitalInputPin<DigitalInputPin> {

    public AbstractDigitalInputPin(int number, String name) {
        super(number, name);
    }

    @Override
    public boolean isHigh(){
        return (value() == Signal.High);
    }

    @Override
    public boolean isLow(){
        return (value() == Signal.High);
    }

    @Override
    public abstract Signal value();
}
