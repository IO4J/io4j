package com.io4j;

public abstract class AbstractExpander extends AbstractProviderContainer implements Expander {

    protected final String name;
    protected Context context;

    public AbstractExpander(String name){
        this.name = name;
    }

    @Override
    public String name() { return this.name; }

    @Override
    public String toString(){
        return String.format("[<%s> %s]", this.getClass().getName(), this.name);
    }

    @Override
    public boolean isExpander(String name){
        return name.equals(this.name);
    }

    @Override
    public boolean isExpander(Expander expander){
        return isExpander(expander.name());
    }

    @Override
    public boolean equals(Object object){
        return ((object instanceof Expander) && isExpander((Expander)object));
    }

    @Override
    public boolean equals(String name){
        return isExpander(name);
    }

    @Override
    public boolean equals(Expander expander){
        return  isExpander(expander);
    }

    @Override
    public abstract boolean isSupported(Context context);

    @Override
    public Expander context(Context context){
        this.context = context;
        return this;
    }

    @Override
    public Context context(){
        return this.context;
    }
}
