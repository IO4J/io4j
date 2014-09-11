package com.io4j;


public interface Platform extends ProviderContainer, Comparable <Platform>{

    public static int DEFAULT_WEIGHT = 1;

    String name();

    boolean isPlatform(String name);
    boolean isPlatform(Platform platform);

    @Override
    boolean equals(Object object);
    boolean equals(String name);
    boolean equals(Platform platform);

    boolean isSupported(Context context);

    Platform context(Context context);
    Context context();

    int weight();
}
