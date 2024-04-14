package com.example.myapplication.Activity;



import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.Object.User;
import com.example.myapplication.R;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;


public class ManageEvent extends AppCompatActivity {

    Button btn_create;
    TextView showw1;
    List<User> ar;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_event);
        btn_create=findViewById(R.id.button_show);
        ar=new ArrayList<>();
        getList();

        showw1=findViewById(R.id.textgetData);
        btn_create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                showw1.setText(String.valueOf(ar.size()));



            }
        });




    }
    private void getList() {
//        int l=0;
//        FirebaseDatabase database= FirebaseDatabase.getInstance();
//        DatabaseReference myref= database.getReference("tblUser");
//        ar=new ArrayList<>();
//        myref.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot snapshot) {
//                for (DataSnapshot dataSnapshot :snapshot.getChildren())
//                {
//                    User us= dataSnapshot.getValue(User.class);
//                    if(us!=null)
//                    {
//                        ar.add(us);}
//                    else {
//
//                        break;
//                    }
//
//                }
//
//
//
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
//                Toast.makeText(ManageEvent.this,"fail to get list",Toast.LENGTH_SHORT).show();
//
//            }
//        });
        FirebaseDatabase database= FirebaseDatabase.getInstance();
        DatabaseReference myref= database.getReference("tblUser");
        myref.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                User use= snapshot.getValue(User.class);
                if(use!=null)
                {
                    ar.add(use);

                }

            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot snapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });




    }
}