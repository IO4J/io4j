package com.io4j.raspi.io.serial;

import com.io4j.Platform;
import com.io4j.io.serial.AbstractSerialProvider;
import com.io4j.io.serial.SerialProvider;

public class RaspiSerialProvider extends AbstractSerialProvider implements SerialProvider {

    public static final String PROVIDER_NAME = "RPI.SERIAL.PROVIDER";

    public RaspiSerialProvider(Platform platform) {
        super(PROVIDER_NAME);
    }
}
