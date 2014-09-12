package com.io4j;


public interface Service<SERVICE_TYPE> extends ProviderContainer{

    String name();

    boolean isCompatible(Context context);

    SERVICE_TYPE context(Context context);
    Context context();

    @Override
    boolean equals(Object obj);
    boolean equals(String name);
}
