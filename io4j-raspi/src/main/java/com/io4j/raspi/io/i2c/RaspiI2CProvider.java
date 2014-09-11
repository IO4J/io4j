package com.io4j.raspi.io.i2c;

import com.io4j.Platform;
import com.io4j.io.i2c.AbstractI2CProvider;
import com.io4j.io.i2c.I2CProvider;

public class RaspiI2CProvider extends AbstractI2CProvider implements I2CProvider {

    public static final String PROVIDER_NAME = "RPI.I2C.PROVIDER";

    public RaspiI2CProvider(Platform platform) {
        super(PROVIDER_NAME);
    }
}
