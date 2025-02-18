package com.example.myapplication.Fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myapplication.Activity.InformationEvent;
import com.example.myapplication.Activity.Login;
import com.example.myapplication.Activity.ToDoList;
import com.example.myapplication.Object.User;
import com.example.myapplication.R;


public class HomeFragment extends Fragment {


    private ImageView btnListEvent;
    private ImageView btnWorkList;
    private  ImageView btnLogOut;
    private TextView nameUser;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        btnListEvent = view.findViewById(R.id.list_event);
        btnWorkList  = view.findViewById(R.id.to_do_list);
        btnLogOut = view.findViewById(R.id.logout);
        if(getArguments()!=null)
        {
        User x= (User) getArguments().get("userLoginComplete");
        nameUser=view.findViewById(R.id.textViewNameUser);
        nameUser.setText(x.getName());
}

        btnListEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent  intent = new Intent(getActivity(), InformationEvent.class);
                startActivity(intent);
            }
        });
        btnWorkList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), ToDoList.class);
                startActivity(intent);
            }
        });

        btnLogOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Login.class);
                startActivity(intent);
            }
        });
    }
}