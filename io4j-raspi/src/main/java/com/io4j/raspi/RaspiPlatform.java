package com.io4j.raspi;

import com.io4j.Context;
import com.io4j.Platform;
import com.io4j.AbstractPlatform;
import com.io4j.raspi.io.gpio.RaspiGpioProvider;
import com.io4j.raspi.io.i2c.RaspiI2CProvider;
import com.io4j.raspi.io.serial.RaspiSerialProvider;
import com.io4j.raspi.io.spi.RaspiSpiProvider;

public class RaspiPlatform extends AbstractPlatform implements Platform {

    public static final String NAME = "Raspberry Pi Platform";

    public RaspiPlatform() {
        super(NAME);

        // add all platform service providers
        addProvider(new RaspiGpioProvider(this));
        addProvider(new RaspiSpiProvider(this));
        addProvider(new RaspiI2CProvider(this));
        addProvider(new RaspiSerialProvider(this));
    }

    @Override
    public boolean isCompatible(Context context) {
        // TODO : implement code to only return 'true' value if running on a Raspberry Pi board
        return true;
    }
}
