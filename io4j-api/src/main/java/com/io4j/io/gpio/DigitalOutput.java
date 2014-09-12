package com.io4j.io.gpio;

import com.io4j.io.Signal;

public interface DigitalOutput extends Digital<DigitalOutput> {
    public DigitalOutput high();
    public DigitalOutput low();
    public DigitalOutput value(boolean high);
    public DigitalOutput value(Signal value);
    public Signal value();
    public boolean isHigh();
    public boolean isLow();
}
