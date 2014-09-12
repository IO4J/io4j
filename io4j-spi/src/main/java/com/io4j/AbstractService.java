package com.io4j;


public abstract class AbstractService<SERVICE_INTERFACE extends Service> extends AbstractProviderContainer implements Service<SERVICE_INTERFACE> {

    protected final String name;
    protected Context context = null;

    public AbstractService(String name){
        this.name = name;
    }

    @Override
    public String name() { return this.name; }

    @Override
    public String toString(){
        return String.format("[<%s> %s]", this.getClass().getName(), this.name);
    }

    @Override
    public boolean equals(String name){
        return name.equals(this.name);
    }

    @Override
    public boolean equals(Object obj){
        if(obj == null) return false;
        if (!(obj instanceof Service)) return false;
        SERVICE_INTERFACE service = (SERVICE_INTERFACE)obj;
        if(service == null) return false;
        return  equals(service.name());
    }

    @Override
    public abstract boolean isCompatible(Context context);

    @Override
    public SERVICE_INTERFACE context(Context context){
        this.context = context;
        return (SERVICE_INTERFACE)this;
    }

    @Override
    public Context context(){
        return this.context;
    }
}
