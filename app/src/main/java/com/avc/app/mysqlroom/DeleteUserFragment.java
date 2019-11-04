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
public class DeleteUserFragment extends Fragment {
    private EditText txtiduser;
    private Button Deletbutton;


    public DeleteUserFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_delete_user, container, false);
        txtiduser=view.findViewById(R.id.userid);
        Deletbutton=view.findViewById(R.id.deletbtn);
        Deletbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id=Integer.parseInt(txtiduser.getText().toString());
                User user=new User();
                user.setId(id);
                MainActivity.myAppDatabase.myDao().deleteUser(user);
                Toast.makeText(getActivity()," user successfully remove",Toast.LENGTH_SHORT).show();
                txtiduser.setText("");
            }
        });


        return  view;
    }

}
