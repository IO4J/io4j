package com.io4j;


public interface Platform extends Service<Platform>, Comparable <Platform>{

    public static int DEFAULT_WEIGHT = 1;

    int weight();

    boolean equals(Platform platform);
}
