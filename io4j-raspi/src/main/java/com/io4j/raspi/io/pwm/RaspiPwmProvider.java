package com.io4j.raspi.io.pwm;

import com.io4j.Platform;
import com.io4j.io.pwm.AbstractPwmProvider;
import com.io4j.io.pwm.PwmProvider;

public class RaspiPwmProvider extends AbstractPwmProvider implements PwmProvider {

    public static final String PROVIDER_NAME = "RPI.PWM.PROVIDER";

    public RaspiPwmProvider(Platform platform) {
        super(PROVIDER_NAME);
    }
}
