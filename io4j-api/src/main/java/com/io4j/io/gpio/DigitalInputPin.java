package com.io4j.io.gpio;

import com.io4j.io.Signal;

public interface DigitalInputPin<PIN_TYPE> extends DigitalPin<PIN_TYPE> {
    public Signal value();
    public boolean isHigh();
    public boolean isLow();
}
