package com.io4j.io.analog;

import com.io4j.io.AbstractPin;

public abstract class AbstractAnalogOutputPin
        extends AbstractPin<AnalogOutputPin>
        implements AnalogOutputPin<AnalogOutputPin> {

    public AbstractAnalogOutputPin(int number, String name) {
        super(number, name);
    }


    @Override
    public abstract AnalogOutputPin value(Number value);

    @Override
    public AnalogOutputPin value(int value) {
        return value(new Integer(value));
    }

    @Override
    public AnalogOutputPin value(long value) {
        return value(new Long(value));
    }

    @Override
    public AnalogOutputPin value(double value) {
        return value(new Double(value));
    }

    @Override
    public AnalogOutputPin value(float value) {
        return value(new Float(value));
    }
}
