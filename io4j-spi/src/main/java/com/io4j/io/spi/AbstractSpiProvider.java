package com.io4j.io.spi;

import com.io4j.AbstractProvider;

public abstract class AbstractSpiProvider extends AbstractProvider<SpiProvider> implements SpiProvider {

    public AbstractSpiProvider(String name){
        super(name);
    }

    @Override
    public String toString(){
        return String.format("[<%s> %s]", this.getClass().getName(), this.name);
    }
}
