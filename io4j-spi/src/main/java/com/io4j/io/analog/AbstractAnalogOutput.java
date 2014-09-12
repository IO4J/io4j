package com.io4j.io.analog;

import com.io4j.io.AbstractPin;

public abstract class AbstractAnalogOutput
        extends AbstractPin<AnalogOutput>
        implements AnalogOutput<AnalogOutput> {

    public AbstractAnalogOutput(int number, String name) {
        super(number, name);
    }


    @Override
    public abstract AnalogOutput value(Number value);

    @Override
    public AnalogOutput value(int value) {
        return value(new Integer(value));
    }

    @Override
    public AnalogOutput value(long value) {
        return value(new Long(value));
    }

    @Override
    public AnalogOutput value(double value) {
        return value(new Double(value));
    }

    @Override
    public AnalogOutput value(float value) {
        return value(new Float(value));
    }
}
