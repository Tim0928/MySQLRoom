package com.avc.app.mysqlroom.Ui;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.avc.app.mysqlroom.MainActivity;
import com.avc.app.mysqlroom.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class Homefragment extends Fragment implements View.OnClickListener{
    private Button bnadduser,bnreaduser,bndeleteuser,btnupdateuser;

    public Homefragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_home, container, false);
        bnadduser=view.findViewById(R.id.adduser);
        bnadduser.setOnClickListener(this);
        bnreaduser=view.findViewById(R.id.viewuser);
        bnreaduser.setOnClickListener(this);
        bndeleteuser=view.findViewById(R.id.deleteuser);
        bndeleteuser.setOnClickListener(this);
        btnupdateuser=view.findViewById(R.id.updateuser);
        btnupdateuser.setOnClickListener(this);









        return view;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.adduser:
                MainActivity.fragmentManager.beginTransaction().replace(
                        R.id.frangment_container,new AddUserFragment()).addToBackStack(null).commit();//??
                break;
            case R.id.viewuser:
                MainActivity.fragmentManager.beginTransaction().replace(
                        R.id.frangment_container,new ReadUserFragment()).addToBackStack(null).commit();//??
                break;
            case R.id.deleteuser:
                MainActivity.fragmentManager.beginTransaction().replace(
                        R.id.frangment_container,new DeleteUserFragment()).addToBackStack(null).commit();//??
                break;
            case R.id.updateuser:
                MainActivity.fragmentManager.beginTransaction().replace(
                        R.id.frangment_container,new UpdateFragment()).addToBackStack(null).commit();//??
                break;


        }

    }


}
