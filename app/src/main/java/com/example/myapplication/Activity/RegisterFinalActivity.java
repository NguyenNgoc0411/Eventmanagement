package com.example.myapplication.Activity;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.*;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.DAO.DAO;
import com.example.myapplication.Object.User;
import com.example.myapplication.R;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RegisterFinalActivity extends AppCompatActivity {
    Button btn_regis;
    User user;
    EditText editPhone,editEmail,editPassword,replyPassword;
    TextView backlogin;
    FirebaseDatabase database= FirebaseDatabase.getInstance();
    DatabaseReference myref= database.getReference("tblUser");
    List<User> ar;
    private int count;







    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_final);
        btn_regis=findViewById(R.id.button_register);
        ar=new ArrayList<>();


        editPhone= findViewById(R.id.editTextPhone);
        editEmail=findViewById(R.id.editTextEmailAddress);
        editPassword=findViewById(R.id.editTextPassword);
        replyPassword=findViewById(R.id.editTextPasswordRely);
        backlogin = findViewById(R.id.BackRe);
        count=0;
        if(getIntent().getExtras()!=null)
        {
        user= (User) getIntent().getExtras().get("user");

        }
        DAO uDAO= new DAO();
        uDAO.getListUser(ar);
        backlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1= new Intent(RegisterFinalActivity.this,Login.class);
                startActivity(intent1);
                finish();
            }
        });


        btn_regis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //khai báo intent thực hiện gọi


                obClickRegister();


            }


        });
}


    private void obClickRegister() {

        String email=editEmail.getText().toString().trim();
        String password=editPassword.getText().toString().trim();


        String phone=editPhone.getText().toString().trim();
        String replyPass=replyPassword.getText().toString().trim();

        boolean check=true;
        if(phone.isEmpty())
        { editPhone.setError("Vui lòng nhập sdt");
            check=false;


        }
        else {
            String phoneRegex="[0][0-9]{9}";
            Matcher phoneMatcher;
            Pattern phonePattern=Pattern.compile(phoneRegex);
            phoneMatcher=phonePattern.matcher(phone);
            if(phone.length()!=10){
                editPhone.setError("Không tồn tại");
                check=false;
            }
            else {
                if(!phoneMatcher.find()){
                    editPhone.setError("Không tồn tại");
                    check=false;
                }
            }
        }

        if(email.isEmpty() )
        {
            editEmail.setError("Vui lòng nhập thông tin");
            check=false;



        }
        else {
            if(!isValidEmail(email))
            {
                editEmail.setError("email không tồn tại");
                check=false;
            }
        }


        if(password.isEmpty())
        {
            editPassword.setError("Vui lòng nhập thông tin");
            check=false;


        }
        if(replyPass.isEmpty())
        {
            replyPassword.setError("Vui lòng xác nhận mật khẩu");
            check=false;


        }
        if(!replyPass.equals(password)){
            replyPassword.setError("Chưa chính xác");
            check=false;


        }
        Toast.makeText(RegisterFinalActivity.this,String.valueOf(ar.size()),Toast.LENGTH_SHORT).show();


        if(check==true)
        {
            boolean check1=true;

            if(ar.size()!=0)
                {



                    for(User a : ar)
                    {
                        if(Integer.parseInt(a.getId().substring(1))>count)
                        {
                            count=Integer.parseInt(a.getId().substring(1));
                        }
                        if(email.equals(a.getEmail())||phone.equals(a.getPhone()))
                        {
                            check1=false;
                        }
                    }



//                    Toast.makeText(RegisterFinalActivity.this,String.valueOf(count),Toast.LENGTH_SHORT).show();

                }




                if(check1==true)
                {

                String x=String.format("U%04d",count+1);
                user.setId(x);
                user.setEmail(email);
                user.setPassword(password);
                user.setUsername(phone);
                user.setPhone(phone);
                myref.child(x).setValue(user);
                showDialogWarning(Gravity.CENTER,1);}
                else
                {
                    showDialogWarning(Gravity.CENTER,0);
                }


        }


    }
    public static boolean isValidEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        Pattern pattern = Pattern.compile(emailRegex);
        return pattern.matcher(email).matches();
    }

    private void showDialogWarning(int gravity,int c) {
        final Dialog dialog1=new Dialog(this);
        dialog1.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog1.setContentView(R.layout.alert_dialog);
        TextView x= dialog1.findViewById(R.id.textViewAlert);
        if(c==0)
        {
            x.setText("Tài khoản đã tồn tại");
        }
        else {
            x.setText("Đăng ký thành công");

        }

        Window window= dialog1.getWindow();
        if(window==null){
            return;
        }
        window.setLayout(WindowManager.LayoutParams.MATCH_PARENT,WindowManager.LayoutParams.WRAP_CONTENT);
        window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        WindowManager.LayoutParams windowAttributes = window.getAttributes();
        windowAttributes.gravity=gravity;
        window.setAttributes(windowAttributes);


        if(Gravity.CENTER==gravity){
            dialog1.setCancelable(true);
        }
        else {
            dialog1.setCancelable(false);
        }

        Button buttonOK=dialog1.findViewById(R.id.button_OK);
        buttonOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(c==1)
                {
                Intent intent = new Intent(RegisterFinalActivity.this,Login.class);
                startActivity(intent);
                finish();
                dialog1.dismiss();}
                else {
                    dialog1.dismiss();
                }
            }
        });
        dialog1.show();
    }
    private void getList() {

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


//    Button btn_continue;
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_register);
//        btn_continue=findViewById(R.id.button_tieptheo);
//        btn_continue.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                //khai báo intent thực hiện gọi
//                Intent myIntentRegister = new Intent(RegisterActivity.this,RegisterFinalActivity.class);
//                startActivity(myIntentRegister);
//            }
//        });
//    }