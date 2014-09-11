package com.io4j.io.analog;

import com.io4j.AbstractProvider;

public abstract class AbstractDacProvider extends AbstractProvider<DacProvider> implements DacProvider {

    public AbstractDacProvider(String name){
        super(name);
    }

    @Override
    public String toString(){
        return String.format("[<%s> %s]", this.getClass().getName(), this.name);
    }
}
