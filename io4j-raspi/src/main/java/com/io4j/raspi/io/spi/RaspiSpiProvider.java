package com.io4j.raspi.io.spi;

import com.io4j.Platform;
import com.io4j.io.spi.AbstractSpiProvider;
import com.io4j.io.spi.SpiProvider;

public class RaspiSpiProvider extends AbstractSpiProvider implements SpiProvider {

    public static final String PROVIDER_NAME = "RPI.SPI.PROVIDER";

    public RaspiSpiProvider(Platform platform) {
        super(PROVIDER_NAME);
    }
}
