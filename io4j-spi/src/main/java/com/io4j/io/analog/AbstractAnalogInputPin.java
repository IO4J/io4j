package com.io4j.io.analog;

import com.io4j.io.AbstractPin;

public abstract class AbstractAnalogInputPin
        extends AbstractPin<AnalogInputPin>
        implements AnalogInputPin<AnalogInputPin> {

    public AbstractAnalogInputPin(int number, String name) {
        super(number, name);
    }

    protected Number value;

    @Override
    public Number value() {
        return value;
    }

    @Override
    public double doubleValue() {
        return value.doubleValue();
    }

    @Override
    public long longValue() {
        return value.longValue();
    }

    @Override
    public float floatValue() {
        return value.floatValue();
    }

    @Override
    public int intValue() {
        return value.intValue();
    }
}
