package com.io4j;

public abstract class AbstractProvider<PROVIDER_TYPE> implements Provider {

    protected final String name;
    protected Context context;

    public AbstractProvider(String name){
        this.name = name;
    }

    @Override
    public String name() { return this.name; }

    @Override
    public String toString(){
        return String.format("[<%s> %s]", this.getClass().getName(), this.name);
    }

    @Override
    public boolean isProvider(String name){
        return name.equals(this.name);
    }

    @Override
    public boolean isProvider(Provider provider){
        return isProvider(provider.name());
    }

    @Override
    public boolean equals(Object object){
        return ((object instanceof Provider) && isProvider((Provider) object));
    }

    @Override
    public boolean equals(String name){
        return isProvider(name);
    }

    @Override
    public boolean equals(Provider provider){
        return  isProvider(provider);
    }

    @Override
    public Provider context(Context context){
        this.context = context;
        return this;
    }

    @Override
    public Context context(){
        return this.context;
    }

    @Override
    public <P extends Provider> P as(Class<P> type){
        return type.cast(this);
    }
}
