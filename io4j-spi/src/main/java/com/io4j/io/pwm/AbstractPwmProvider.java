package com.io4j.io.pwm;

import com.io4j.AbstractProvider;

public abstract class AbstractPwmProvider extends AbstractProvider<PwmProvider> implements PwmProvider {

    public AbstractPwmProvider(String name){
        super(name);
    }

    @Override
    public String toString(){
        return String.format("[<%s> %s]", this.getClass().getName(), this.name);
    }
}
