package com.example.myapplication.DAO;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.myapplication.Object.AddressOrganization;
import com.example.myapplication.Object.Event;
import com.example.myapplication.Object.User;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class DAO {

    public DAO()
    {

    }


    public  void  getListUser(List<User> ar)
    {
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
    public void getAddressOrganization(List<AddressOrganization> listaddress)
    {    FirebaseDatabase database= FirebaseDatabase.getInstance();
        DatabaseReference myref= database.getReference("tblAddressOrganization");
        myref.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
//                Event evn= new Event();
//                evn.setId(snapshot.child("id").getValue().toString());
//                evn.setName(snapshot.child("name").getValue().toString());
//                evn.setDateCreate(snapshot.child("dateCreate").getValue().toString());
//                evn.setBeginTime(snapshot.child("beginTime").getValue().toString());
//                evn.setEndTime(snapshot.child("endTime").getValue().toString());
//                evn.setCapacity(Integer.parseInt(snapshot.child("capacity").getValue().toString()));
//                evn.setAddress(snapshot.child("address").getValue().toString());
                  AddressOrganization ad= new AddressOrganization();
                  ad.setId(snapshot.child("id").getValue().toString());
                  ad.setName(snapshot.child("name").getValue().toString());
                  ad.setAddress(snapshot.child("address").getValue().toString());
                  ad.setPrice(Integer.parseInt(snapshot.child("price").getValue().toString()));
                  ad.setStatus(Integer.parseInt(snapshot.child("status").getValue().toString()));
                  if(ad!=null)
                  {
                      listaddress.add(ad);
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
    public  void getAllEvent(List<Event> eventList)
    {
        FirebaseDatabase database= FirebaseDatabase.getInstance();
        DatabaseReference myref= database.getReference("tblEvent");
        myref.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                Event e= new Event();


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

