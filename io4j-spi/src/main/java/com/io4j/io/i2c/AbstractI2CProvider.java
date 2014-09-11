package com.io4j.io.i2c;

import com.io4j.AbstractProvider;

public abstract class AbstractI2CProvider extends AbstractProvider<I2CProvider> implements I2CProvider {

    public AbstractI2CProvider(String name){
        super(name);
    }

    @Override
    public String toString(){
        return String.format("[<%s> %s]", this.getClass().getName(), this.name);
    }
}
