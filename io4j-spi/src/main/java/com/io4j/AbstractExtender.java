package com.io4j;

public abstract class AbstractExtender extends AbstractService<Extender> implements Extender {

    public AbstractExtender(String name){
        super(name);
    }

    @Override
    public boolean equals(Extender extender){
        if(extender == null) return false;
        return  equals(extender.name());
    }

    @Override
    public abstract boolean isCompatible(Context context);
}
