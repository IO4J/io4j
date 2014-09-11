package com.io4j.io.gpio;

import com.io4j.io.AbstractPin;
import com.io4j.io.Signal;

public abstract class AbstractDigitalIOPin
        extends AbstractPin<DigitalIOPin>
        implements DigitalIOPin {

    public AbstractDigitalIOPin(int number, String name) {
        super(number, name);
    }

    @Override
    public DigitalIOPin high() {
        return value(Signal.High);
    }

    @Override
    public DigitalIOPin low() {
        return value(Signal.Low);
    }

    @Override
    public DigitalIOPin value(boolean high){
        return value( high ? Signal.High : Signal.Low );
    }

    @Override
    public abstract DigitalIOPin value(Signal value);

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
