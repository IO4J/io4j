package com.io4j.io;

import java.util.Collection;

public interface PinProvider<PIN_PROVIDER_TYPE, PIN_INTERFACE_TYPE> extends IoProvider<PIN_PROVIDER_TYPE> {

    Collection<Pin> pins();
    Collection<Pin> pins(String... name);
    Collection<Pin> pins(int... number);

    boolean hasPin(int number);
    boolean hasPin(String name);

    boolean hasPins(int... number);
    boolean hasPins(String... name);

    <PIN_TYPE extends PIN_INTERFACE_TYPE> PIN_TYPE pin(int number);
    <PIN_TYPE extends PIN_INTERFACE_TYPE> PIN_TYPE pin(int number, Class<PIN_TYPE> type);

    <PIN_TYPE extends PIN_INTERFACE_TYPE> PIN_TYPE pin(String name);
    <PIN_TYPE extends PIN_INTERFACE_TYPE> PIN_TYPE pin(String name, Class<PIN_TYPE> type);
}
