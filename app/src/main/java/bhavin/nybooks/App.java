package bhavin.nybooks;

import android.app.Application;

/**
 * Created by Bhavin on 4/25/2018.
 */

public class App extends Application {
    private static App mInstance;

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
    }
    public static synchronized App getInstance() {
        return mInstance;
    }
}
