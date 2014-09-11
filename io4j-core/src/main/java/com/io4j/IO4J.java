package com.io4j;


import com.io4j.exception.PlatformResolutionException;

public class IO4J {

    private static Context context = null;

    public static Context instance(){
        if(context == null){
            context = new DefaultContext();
        }
        return context;
    }

    public static Context instance(Platform platform){
        if(context == null){ newInstance(platform); }
        return context;
    }

    public static Context instance(Class<? extends Platform> platformClass) throws PlatformResolutionException {
        if(context == null){ newInstance(platformClass); }
        return context;
    }

    public static Context instance(String platformName) throws PlatformResolutionException {
        if(context == null){ newInstance(platformName); }
        return context;
    }

    public static Context newInstance(Platform platform){
        context = new DefaultContext();
        context.setPlatform(platform);
        return context;
    }

    public static Context newInstance(Class<? extends Platform> platformClass) throws PlatformResolutionException {
        context = new DefaultContext();
        context.setPlatform(platformClass);
        return context;
    }

    public static Context newInstance(String platformName) throws PlatformResolutionException {
        context = new DefaultContext();
        context.setPlatform(platformName);
        return context;
    }

}
