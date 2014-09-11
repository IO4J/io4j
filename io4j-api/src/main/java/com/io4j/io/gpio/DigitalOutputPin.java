package com.io4j.io.gpio;

import com.io4j.io.Signal;

public interface DigitalOutputPin<PIN_TYPE> extends DigitalPin<PIN_TYPE> {
    public PIN_TYPE high();
    public PIN_TYPE low();
    public PIN_TYPE value(boolean high);
    public PIN_TYPE value(Signal value);
}
