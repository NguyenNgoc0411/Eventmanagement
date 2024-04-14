package com.example.myapplication.Activity;

import static com.example.myapplication.Activity.RegisterActivity.MY_REQUEST_CODE;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
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

import com.example.myapplication.DAO.DAO;
import com.example.myapplication.Object.User;
import com.example.myapplication.R;

import java.util.ArrayList;
import java.util.List;

public class Login extends AppCompatActivity {

    private Button btnLogin;
    private TextView register;
    private List<User> ar;


    private EditText username,password;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        register= findViewById(R.id.register_next);
        username= findViewById(R.id.textUserName);
        password=findViewById(R.id.textPaddword);
        ar= new ArrayList<>();
        DAO uDao= new DAO();
        uDao.getListUser(ar);


        register.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent= new Intent(Login.this, RegisterActivity.class);
                startActivity(intent);
            }
        });
        btnLogin = findViewById(R.id.login);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String textusername=  username.getText().toString().trim();
                String textpassword=password.getText().toString().trim();

                boolean check=true;
                for (User h:ar)
                {
                    if(h.getUsername().equals(textusername)&&h.getPassword().equals(textpassword))

                    {
                        check=false;
                        Intent intent = new Intent(Login.this, Home.class);

                    Bundle bundle = new Bundle();
                    bundle.putSerializable("userLogin", h);
                    intent.putExtras(bundle);
                    startActivityForResult(intent, MY_REQUEST_CODE);
                    break;
                    }
                }
                if(check==true)
                {
                    showDialogWarning(Gravity.CENTER,0);
                }


//                if(uDao.checkUser(ar,textusername,textpassword)!=null) {
//                    Intent intent = new Intent(Login.this, Home.class);
//                    User a = uDao.checkUser(ar, textusername, textpassword);
//                    Bundle bundle = new Bundle();
//                    bundle.putSerializable("userLogin", a);
//                    intent.putExtras(bundle);
//                    startActivityForResult(intent, MY_REQUEST_CODE);
//
//
//                }

            }
        });
    }
    private void showDialogWarning(int gravity,int c) {
        final Dialog dialog1=new Dialog(this);
        dialog1.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog1.setContentView(R.layout.alert_dialog);
        TextView x= dialog1.findViewById(R.id.textViewAlert);
        if(c==0)
        {
            x.setText("Tài khoản không tồn tại");
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
                dialog1.dismiss();
            }
        });
        dialog1.show();
    }
}