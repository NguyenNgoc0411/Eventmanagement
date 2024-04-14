package com.example.myapplication.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myapplication.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
//    ConnectDatabase connectDatabase;
//    Connection conn;
//    ResultSet rs;
//    String name, str;
    private FirebaseDatabase db;
    private DatabaseReference ref;
    private EditText editText;
    private Button btn;
    private Button btnGetData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db=FirebaseDatabase.getInstance();
        ref=db.getReference();
        editText=findViewById(R.id.listuser);
        btn=findViewById(R.id.buttonconnect);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                ref.setValue(editText.getText().toString());
                product pro= new product(1000,"bàn phím cơ",15267839);
                ref.child("products").child(String.valueOf(pro.getId())).setValue(pro);
            }
        });
        btnGetData=findViewById(R.id.buttongetData);
        btnGetData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Task<DataSnapshot> task= ref.get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<DataSnapshot> task) {
                        if(task.isSuccessful()){
                            Object obj=task.getResult().getValue();
                            Toast.makeText(MainActivity.this,obj.toString(),Toast.LENGTH_SHORT).show();



                        }
                    }
                });

            }
        });
//        connectDatabase = new ConnectDatabase();
//        connect();
    }

//    public void btnCick(View view) {
////        ExecutorService executorService= Executors.newSingleThreadExecutor();
////        executorService.execute(() -> {
////            try {
////                conn=connectDatabase.CONN();
////                String query = "SELECT * FROM PERSON";
////                PreparedStatement stmt= conn.prepareStatement(query);
////                rs= stmt.executeQuery();
////                StringBuilder bStr= new StringBuilder("User list\n");
////                while (rs.next())
////                {
////                    bStr.append(rs.getString("username")).append("\n");
////
////                }
////                name= bStr.toString();
////
////            }catch (Exception e)
////            {
////                throw new RuntimeException(e);
////            }
////            runOnUiThread(() -> {
////                try {
////                    Thread.sleep(1000);
////                }
////                catch (InterruptedException e)
////                {
////                    e.printStackTrace();
////                }
////                TextView textList= findViewById(R.id.listuser);
////                textList.setText(name);
////            });
////        });
////    }
////    public void connect()
////    {
////        ExecutorService executorService= Executors.newSingleThreadExecutor();
////        executorService.execute(() -> {
////            try {
////                conn=connectDatabase.CONN();
////                if(conn==null)
////                {
////                    str="Error in connection Mysql";
////                }
////                else {
////                    str="Connection succesfull";
////                }
////            }catch (Exception e)
////            {
////                throw new RuntimeException(e);
////            }
////            runOnUiThread(() -> {
////                try {
////                    Thread.sleep(1000);
////                }
////                catch (InterruptedException e)
////                {
////                    e.printStackTrace();
////                }
////                Toast.makeText(this,str,Toast.LENGTH_SHORT).show();
////        });
////    });
//    }
}