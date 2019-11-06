package com.avc.app.mysqlroom;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.room.Room;

import android.os.Bundle;

import com.avc.app.mysqlroom.Ui.Homefragment;

public class MainActivity extends AppCompatActivity {
    public static FragmentManager fragmentManager;
    public static MyAppDatabase myAppDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragmentManager= getSupportFragmentManager();
        myAppDatabase=Room.databaseBuilder(getApplicationContext(),MyAppDatabase.class,"userdb").allowMainThreadQueries().build();

      //  myAppDatabase=MyAppDatabase(Context.getApplicationContext());
        if(findViewById(R.id.frangment_container)!=null){

            if(savedInstanceState!=null){
                return;
            }
            fragmentManager.beginTransaction().add(R.id.frangment_container,new Homefragment()).commit();//這個不太懂要熟悉
        }
    }
}
