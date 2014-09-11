package com.io4j.example;


import com.io4j.GPIO;
import com.io4j.exception.PlatformResolutionException;
import com.io4j.io.Signal;
import com.io4j.io.gpio.DigitalIOPin;

public class SimpleGpioExample {

    public static void main(String ... arguments) throws PlatformResolutionException {

        // instantiate SIMPLE GPIO
        GPIO gpio = new GPIO();

        // create simple GPIO I/O pin
        DigitalIOPin pin = gpio.pin(2);

        // interact with simple GPIO I/O pin
        System.out.println("Simple GPIO pin   : " + pin.name());
        System.out.println("Simple GPIO value : " + pin.value(Signal.High).value());
        System.out.println("Simple GPIO value : " + pin.value(Signal.Low).value());
    }
}
