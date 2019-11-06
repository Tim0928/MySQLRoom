package com.avc.app.mysqlroom;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.Handler;
import android.os.IBinder;
import android.util.Log;

import java.util.Date;
import java.util.Random;

public class MyService extends Service {
    public MyService() {
    }
    // Binder given to clients
    private final IBinder mBinder = new LocalBinder();
    // Random number generator
    private static final Random mGenerator = new Random();

    private Handler handler=new Handler();//這個要了解
    private  Runnable showtime =new Runnable() {
        @Override
        public void run() {
            Log.i("MyService",new Date().toString());
            handler.postDelayed(this,1000);
        }
    };

    /**
     * Class used for the client Binder.  Because we know this service always
     * runs in the same process as its clients, we don't need to deal with IPC.
     */
    public class LocalBinder extends Binder {
        MyService getService() {
            // Return this instance of LocalService so clients can call public methods
            return MyService.this;
        }
    }

    public void run() {
        handler.post(showtime);

    }
    @Override
    public IBinder onBind(Intent intent) {
        Log.i("MyService","onBind");
        return mBinder;
    }

    /** method for clients */
    public static int getRandomNumber() {
        Log.i("MyService","getRandomNumber");
        return mGenerator.nextInt(100);
    }
    @Override
    public  boolean onUnbind(Intent intent){
        Log.i("MyService","onUnbind");
        handler.removeCallbacks(showtime);
        //handler.
        return super.onUnbind(intent);
    }
    @Override
    public  void  onRebind(Intent intent){
        Log.i("MyService","onRebind");
        super.onRebind(intent);
    }
}
