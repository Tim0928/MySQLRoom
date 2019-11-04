package com.avc.app.mysqlroom;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class AddUserFragment extends Fragment implements View.OnClickListener{
    private Button buadduser;

    public AddUserFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_add_user, container, false);
        buadduser=view.findViewById(R.id.bn_save);
        buadduser.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
       // switch ()

    }


}
