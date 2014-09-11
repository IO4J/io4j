package com.io4j;

public interface Provider {
    String name();
    boolean isProvider(String name);
    boolean isProvider(Provider provider);
    <P extends Provider> P as(Class<P> type);

    @Override
    boolean equals(Object object);
    boolean equals(String name);
    boolean equals(Provider provider);

    Provider context(Context context);
    Context context();
}
