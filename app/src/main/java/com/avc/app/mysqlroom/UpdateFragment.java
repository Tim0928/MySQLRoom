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
public class UpdateFragment extends Fragment {
    private EditText userid,username,useremail;
    private Button Bnupdate;

    public UpdateFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_update, container, false);
        userid=view.findViewById(R.id.txt_user_id);
        username=view.findViewById(R.id.txt_user_name);
        useremail=view.findViewById(R.id.txt_user_email);
        Bnupdate=view.findViewById(R.id.updatebtn);

        Bnupdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id=Integer.parseInt(userid.getText().toString());
                String name=username.getText().toString();
                String email=useremail.getText().toString();
                User user=new User();
                user.setId(id);
                user.setName(name);
                user.setEmail(email);
                MainActivity.myAppDatabase.myDao().updateUser(user);
                Toast.makeText(getActivity(),"update successful",Toast.LENGTH_SHORT).show();
                userid.setText("");
                username.setText("");
                useremail.setText("");


            }
        });
        return view;
    }

}
