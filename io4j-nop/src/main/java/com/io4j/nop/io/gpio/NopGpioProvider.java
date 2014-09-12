package com.io4j.nop.io.gpio;

import com.io4j.Platform;
import com.io4j.io.gpio.AbstractGpioProvider;
import com.io4j.io.gpio.GpioProvider;

public class NopGpioProvider extends AbstractGpioProvider implements GpioProvider {

    public static final String PROVIDER_NAME = "NOP.GPIO.PROVIDER";

    public static final int PIN_COUNT = 5;

    public static final String PIN_NAME_1 = "PIN-1";
    public static final String PIN_NAME_2 = "PIN-2";
    public static final String PIN_NAME_3 = "PIN-3";
    public static final String PIN_NAME_4 = "PIN-4";
    public static final String PIN_NAME_5 = "PIN-5";

    public NopGpioProvider(Platform platform) {
        super(PROVIDER_NAME);
        addPin(new NopGpioOutput(1, PIN_NAME_1));
        addPin(new NopGpioOutput(2, PIN_NAME_2));
        addPin(new NopGpioOutput(3, PIN_NAME_3));
        addPin(new NopGpioOutput(4, PIN_NAME_4));
        addPin(new NopGpioOutput(5, PIN_NAME_5));
    }


}
