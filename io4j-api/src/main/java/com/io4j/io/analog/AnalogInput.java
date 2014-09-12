package com.io4j.io.analog;

public interface AnalogInput<PIN_TYPE> extends Analog<PIN_TYPE> {
    public Number value();
    public double doubleValue();
    public long longValue();
    public float floatValue();
    public int intValue();
}
