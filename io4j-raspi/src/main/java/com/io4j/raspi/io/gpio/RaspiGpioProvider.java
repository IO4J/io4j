package com.io4j.raspi.io.gpio;

import com.io4j.Platform;
import com.io4j.io.gpio.AbstractGpioProvider;
import com.io4j.io.gpio.GpioProvider;

public class RaspiGpioProvider extends AbstractGpioProvider implements GpioProvider {

    public static final String PROVIDER_NAME = "RPI.GPIO.PROVIDER";

    public static final int PIN_COUNT = 5;

    public static final String PIN_NAME_1 = "PIN-1";
    public static final String PIN_NAME_2 = "PIN-2";
    public static final String PIN_NAME_3 = "PIN-3";
    public static final String PIN_NAME_4 = "PIN-4";
    public static final String PIN_NAME_5 = "PIN-5";

    public RaspiGpioProvider(Platform platform) {
        super(PROVIDER_NAME);
        addPin(new RaspiGpioPin(1, PIN_NAME_1));
        addPin(new RaspiGpioPin(2, PIN_NAME_2));
        addPin(new RaspiGpioPin(3, PIN_NAME_3));
        addPin(new RaspiGpioPin(4, PIN_NAME_4));
        addPin(new RaspiGpioPin(5, PIN_NAME_5));
    }


}
