package science.denghaoyu.fascinatingmanager;

import android.app.Application;
import android.content.Context;

import org.litepal.LitePal;

import java.sql.Connection;

/**
 * Created by dhy on 18-2-4.
 */

public class FMApplication extends Application {
    private static Context context;
    public FMApplication(){

    }

    @Override
    public void onCreate() {
        super.onCreate();
        FMApplication.context = getApplicationContext();
        LitePal.initialize(context);
    }

    public static  Context getContext(){
        return FMApplication.context;
    }
}
