package com.io4j.io;

public abstract class AbstractPin<PIN_TYPE> implements Pin<PIN_TYPE> {

    protected String name;
    protected int number;

    public AbstractPin(int number, String name){
        this.number = number;
        this.name = name;
    }

    @Override
    public <P extends Pin> P as(Class<P> type){
        return type.cast(this);
    }

    @Override
    public String name() { return this.name; }

    @Override
    public int number() { return this.number; }


    @Override
    public String toString(){
        return String.format("[<%s> %s (#%d)]", this.getClass().getName(), this.name, this.number);
    }

}
