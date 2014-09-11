package com.io4j;

public interface Expander extends ProviderContainer {

    String name();
    boolean isExpander(String name);
    boolean isExpander(Expander expander);

    @Override
    boolean equals(Object object);
    boolean equals(String name);
    boolean equals(Expander expander);

    boolean isSupported(Context context);

    Expander context(Context context);
    Context context();
}
