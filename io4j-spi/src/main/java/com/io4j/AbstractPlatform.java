package com.io4j;


public abstract class AbstractPlatform extends AbstractProviderContainer implements Platform {

    protected final String name;
    protected Context context = null;

    public AbstractPlatform(String name){
        this.name = name;
    }

    @Override
    public String name() { return this.name; }

    @Override
    public String toString(){
        return String.format("[<%s> %s]", this.getClass().getName(), this.name);
    }

    @Override
    public boolean isPlatform(String name){
        return name.equals(this.name);
    }

    @Override
    public boolean isPlatform(Platform platform){
        return isPlatform(platform.name());
    }

    @Override
    public boolean equals(Object object){
        return ((object instanceof Platform) && isPlatform((Platform) object));
    }

    @Override
    public boolean equals(String name){
        return isPlatform(name);
    }

    @Override
    public boolean equals(Platform platform){
        return  isPlatform(platform);
    }

    @Override
    public abstract boolean isSupported(Context context);

    @Override
    public Platform context(Context context){
        this.context = context;
        return this;
    }

    @Override
    public Context context(){
        return this.context;
    }

    @Override
    public int weight() {
        return Platform.DEFAULT_WEIGHT;
    }

    @Override
    public int compareTo(Platform o) {
        if(this.weight() == o.weight()){
            return 0;
        }
        else if (this.weight() > o.weight()){
            return 1;
        }
        return -1;
    }
}
