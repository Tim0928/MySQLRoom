package com.avc.app.mysqlroom.Ui;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.avc.app.mysqlroom.MainActivity;
import com.avc.app.mysqlroom.R;
import com.avc.app.mysqlroom.User;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class ReadUserFragment extends Fragment {
    private TextView Textinfo;

    public ReadUserFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_read_user, container, false);
        Textinfo =view.findViewById(R.id.txt_display_info);
        List<User>users=MainActivity.myAppDatabase.myDao().getuser();
        String info="";
        for(User user:users){
            int id=user.getId();
            String  name=user.getName();
            String  email=user.getEmail();
            info =info+"\n\n"+"Id :"+id+"\n Name :"+name+"\n Email :"+email;
        }
        Textinfo.setText(info);
        return view;
    }

}
