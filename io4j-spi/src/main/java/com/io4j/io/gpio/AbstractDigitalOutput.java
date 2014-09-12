package com.io4j.io.gpio;

import com.io4j.io.AbstractPin;
import com.io4j.io.Signal;

public abstract class AbstractDigitalOutput
        extends AbstractPin<DigitalOutput>
            implements DigitalOutput {

    // internal cached last known value
    protected Signal value = Signal.Unknown;

    public AbstractDigitalOutput(int number, String name) {
        super(number, name);
    }

    @Override
    public DigitalOutput high() {
        return value(Signal.High);
    }

    @Override
    public DigitalOutput low() {
        return value(Signal.Low);
    }

    @Override
    public DigitalOutput value(boolean high){
        return value( high ? Signal.High : Signal.Low );
    }

    @Override
    public abstract DigitalOutput value(Signal value);

    @Override
    public Signal value() { return value; }

    @Override
    public boolean isHigh(){
        return (value() == Signal.High);
    }

    @Override
    public boolean isLow(){
        return (value() == Signal.Low);
    }

}
