package com.io4j.io;

import com.io4j.util.IO4JUtil;

public enum Signal {
    Unknown(-1, null),
    High(1, true),
    Low(0, false);

    public static final String HIGH = "high";
    public static final String LOW = "low";

    private int numericValue;
    private Boolean booleanValue;

    Signal(int numericValue, Boolean booleanValue) {
        this.numericValue = numericValue;
        this.booleanValue = booleanValue;
    }

    public int getNumericValue() {
        return numericValue;
    }

    public boolean getBooleanValue() {
        return booleanValue;
    }

    public static Signal fromNumericValue(int value) {
        if (value == 0) {
            return Signal.Low;
        }
        return Signal.High;
    }

    public static Signal fromBooleanValue(boolean value) {
        if (value) {
            return Signal.High;
        }
        return Signal.Low;
    }

    public static Signal fromString(String value) {
        if (value == null) {
            throw new IllegalArgumentException("value cannot be null!");
        }
        ;

        String interpretedValue = value.trim().toLowerCase();

        if (IO4JUtil.isStringNumeric(interpretedValue)) {
            if (Double.parseDouble(interpretedValue) == 0) {
                return Signal.Low;
            }
            return Signal.High;
        } else {
            if (interpretedValue.equals(LOW)) {
                return Signal.Low;
            } else if (interpretedValue.equals(HIGH)) {
                return Signal.High;
            }
            ;

            throw new IllegalArgumentException(interpretedValue + " is not a valid value for a signal");
        }
    }

    public Signal inverse() {
        return this == Signal.High ? Signal.Low : Signal.High;
    }
}