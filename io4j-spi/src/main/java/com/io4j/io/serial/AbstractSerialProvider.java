package com.io4j.io.serial;

import com.io4j.AbstractProvider;

public abstract class AbstractSerialProvider extends AbstractProvider<SerialProvider> implements SerialProvider {

    public AbstractSerialProvider(String name){
        super(name);
    }

    @Override
    public String toString(){
        return String.format("[<%s> %s]", this.getClass().getName(), this.name);
    }
}
