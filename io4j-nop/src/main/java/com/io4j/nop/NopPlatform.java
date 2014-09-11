package com.io4j.nop;

import com.io4j.Context;
import com.io4j.Platform;
import com.io4j.AbstractPlatform;

public class NopPlatform extends AbstractPlatform implements Platform {

    public static final String NAME = "No-Op Platform";

    public NopPlatform() {
        super(NAME);
    }

    @Override
    public boolean isSupported(Context context) {
        return true;
    }

    @Override
    public int weight() {
        return 0;
    }
}
