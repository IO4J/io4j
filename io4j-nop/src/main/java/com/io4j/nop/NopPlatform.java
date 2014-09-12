package com.io4j.nop;

import com.io4j.Context;
import com.io4j.Platform;
import com.io4j.AbstractPlatform;
import com.io4j.nop.io.gpio.NopGpioProvider;

public class NopPlatform extends AbstractPlatform implements Platform {

    public static final String NAME = "No-Op Platform";

    public NopPlatform() {
        super(NAME);
        addProvider(new NopGpioProvider(this));
    }

    @Override
    public boolean isCompatible(Context context) {
        return true;
    }

    @Override
    public int weight() {
        return 0;
    }
}
