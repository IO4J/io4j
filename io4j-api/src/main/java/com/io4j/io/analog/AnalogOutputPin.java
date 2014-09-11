package com.io4j.io.analog;

public interface AnalogOutputPin<PIN_TYPE> extends AnalogPin<PIN_TYPE> {
    public PIN_TYPE value(Number value);
    public PIN_TYPE value(int value);
    public PIN_TYPE value(long value);
    public PIN_TYPE value(double value);
    public PIN_TYPE value(float value);
}
