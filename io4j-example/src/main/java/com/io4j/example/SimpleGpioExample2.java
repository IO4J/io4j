package com.io4j.example;


import com.io4j.GPIOPin;
import com.io4j.exception.PlatformResolutionException;
import com.io4j.io.Signal;
import com.io4j.io.gpio.DigitalIOPin;

public class SimpleGpioExample2 {

    public static void main(String ... arguments) throws PlatformResolutionException {

        // instantiate SIMPLE GPIO I/O Pin
        DigitalIOPin pin = new GPIOPin(1);

        // interact with simple GPIO I/O pin
        System.out.println("Simple GPIO pin   : " + pin.name());
        System.out.println("Simple GPIO value : " + pin.value(Signal.High).value());
        System.out.println("Simple GPIO value : " + pin.value(Signal.Low).value());
    }
}
