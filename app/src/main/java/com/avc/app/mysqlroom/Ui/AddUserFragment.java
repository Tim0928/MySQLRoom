package com.avc.app.mysqlroom.Ui;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.avc.app.mysqlroom.Book;
import com.avc.app.mysqlroom.MainActivity;
import com.avc.app.mysqlroom.MyService;
import com.avc.app.mysqlroom.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class AddUserFragment extends Fragment {
    private EditText userid,username,useremail;
    private Button Bnsave;
    //private addfactory maddfactory;
   // MyService mService;
    public AddUserFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_add_user , container, false);
    //    return inflater.inflate(R.layout.fragment_add_user , container, false);
        userid=view.findViewById(R.id.txt_userid);
        username=view.findViewById(R.id.txt_username);
        useremail=view.findViewById(R.id.txt_useremail);
        Bnsave=view.findViewById(R.id.bn_save);




        Bnsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                int useridnum=Integer.parseInt(userid.getText().toString());


                String usernamestr=username.getText().toString();
                String useremailstr=useremail.getText().toString();

                Book user=new Book();
                user.setId(useridnum);
                user.setBook_name(usernamestr);
                user.setBook_conext(useremailstr);
             //   MainActivity.myAppDatabase.myDao().addUser(user);

                Log.i("MyService","stopButton");
                Toast.makeText(getActivity(),"add user successful:",Toast.LENGTH_SHORT).show();
                userid.setText("");
                username.setText("");
                useremail.setText("");

                Adduser(user );

            }
        });


        displayDistance();

        return view;
    }
    private void displayDistance(){
     // this.Bnsave.setText("123");
        final Handler handler=new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                Bnsave.setText("Random:"+MyService.getRandomNumber(10));
 //               Log.i("MyService","ui getRandomNumber:"+MyService.getRandomNumber(10));
                handler.postDelayed(this,2000);

            }
        });

    }


    private void Adduser(final Book userinfo){
        // this.Bnsave.setText("123");
        final Handler handler=new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                 Bnsave.setText("Random:"+MyService.getRandomNumber(10));
                MyService.addUser(userinfo);
                // handler.postDelayed(this,100);

            }
        });

    }



}
