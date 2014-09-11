package com.io4j.io.analog;

public interface AnalogInputPin<PIN_TYPE> extends AnalogPin<PIN_TYPE> {
    public Number value();
    public double doubleValue();
    public long longValue();
    public float floatValue();
    public int intValue();
}
