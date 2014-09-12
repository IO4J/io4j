package com.io4j.io.gpio;

import com.io4j.io.Signal;

public interface DigitalInput extends Digital<DigitalInput> {
    public Signal value();
    public boolean isHigh();
    public boolean isLow();
}
