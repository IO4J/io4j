package com.io4j.io;

public interface Pin<PIN_TYPE> {
    <P extends Pin> P as(Class<P> type);
    String name();
    int number();
}
