package com.avc.app.mysqlroom;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class AddUserFragment extends Fragment {
    private EditText userid,username,useremail;
    private Button Bnsave;

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

                User user=new User();
                user.setId(useridnum);
                user.setName(usernamestr);
                user.setEmail(useremailstr);
                MainActivity.myAppDatabase.myDao().addUser(user);
                Toast.makeText(getActivity(),"add user successful",Toast.LENGTH_SHORT).show();
                userid.setText("");
                username.setText("");
                useremail.setText("");


            }
        });
        return view;
    }




}
