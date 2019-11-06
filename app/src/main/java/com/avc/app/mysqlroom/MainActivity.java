package com.avc.app.mysqlroom;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.room.Room;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;

import com.avc.app.mysqlroom.Ui.Homefragment;

public class MainActivity extends AppCompatActivity {
    public static FragmentManager fragmentManager;
    public static MyAppDatabase myAppDatabase;
     MyService mService;


    //new 20191106
    boolean mBound = false;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragmentManager= getSupportFragmentManager();
        myAppDatabase=Room.databaseBuilder(getApplicationContext(),MyAppDatabase.class,"userdb").allowMainThreadQueries().build();

        //new 20191106
        intent = new Intent(getApplicationContext(), MyService.class);
        bindService(intent,mConnection , Context.BIND_AUTO_CREATE);

        Log.i("MyService","onCreate");
        //  myAppDatabase=MyAppDatabase(Context.getApplicationContext());
        if(findViewById(R.id.frangment_container)!=null){

            if(savedInstanceState!=null){
                return;
            }
            fragmentManager.beginTransaction().add(R.id.frangment_container,new Homefragment()).commit();//這個不太懂要熟悉
        }
    }



    private ServiceConnection mConnection = new ServiceConnection() {

        @Override
        public void onServiceConnected(ComponentName className,
                                       IBinder service) {
            // We've bound to LocalService, cast the IBinder and get LocalService instance
            MyService.LocalBinder binder = (MyService.LocalBinder) service;
            mService = binder.getService();
            mBound = true;
            mService.run();
            Log.i("MyService","onServiceConnected");
        }

        @Override
        public void onServiceDisconnected(ComponentName arg0) {
            mBound = false;
        }
    };
    @Override
    protected void onStop() {
        unbindService(mConnection);
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Log.i("MyService","onDestroy");

        super.onDestroy();

      //  Toast.makeText(this, "onDestroy", Toast.LENGTH_LONG).show();
    }


}
