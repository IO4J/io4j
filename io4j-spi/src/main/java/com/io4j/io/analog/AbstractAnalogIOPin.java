package com.io4j.io.analog;

import com.io4j.io.AbstractPin;

public abstract class AbstractAnalogIOPin
        extends AbstractPin<AnalogIOPin>
        implements AnalogIOPin {

    protected Number value;

    public AbstractAnalogIOPin(int number, String name) {
        super(number, name);
    }

    @Override
    public abstract AnalogIOPin value(Number value);

    @Override
    public AnalogIOPin value(int value) {
        return value(new Integer(value));
    }

    @Override
    public AnalogIOPin value(long value) {
        return value(new Long(value));
    }

    @Override
    public AnalogIOPin value(double value) {
        return value(new Double(value));
    }

    @Override
    public AnalogIOPin value(float value) {
        return value(new Float(value));
    }

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
