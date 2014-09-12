package com.io4j;


public abstract class AbstractPlatform extends AbstractService<Platform> implements Platform {

    public AbstractPlatform(String name){
        super(name);
    }

    @Override
    public abstract boolean isCompatible(Context context);

    @Override
    public int weight() {
        return Platform.DEFAULT_WEIGHT;
    }

    @Override
    public boolean equals(Platform platform){
        if(platform == null) return false;
        return  equals(platform.name());
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
