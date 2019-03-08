package com.mine.mishi.mishi;

import android.app.Application;
import android.content.Context;

import com.facebook.drawee.backends.pipeline.Fresco;

/**
 * Created by mj
 * on 2016/10/28.
 */
public class DmmApplication extends Application{
    private static Context context;
    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this);
        context = getApplicationContext();
    }
    public static Context getContext(){
        return context;
    }
}
