package com.example.myapplication.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupMenu;

import com.example.myapplication.R;

public class CreateBudgetEvent extends AppCompatActivity {
    Button btn_creatBuget;
    ImageView showMenu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_budget_event);
        btn_creatBuget=findViewById(R.id.button_createBudget);
        showMenu= findViewById(R.id.showMenuBudget);
        showMenu.setOnClickListener((view)->{
            PopupMenu popupMenuBudget= new PopupMenu(this,view);
            popupMenuBudget.getMenuInflater().inflate(R.menu.menu_budget,popupMenuBudget.getMenu());
            popupMenuBudget.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                @Override
                public boolean onMenuItemClick(MenuItem item) {
                    return false;
                }
            });
            popupMenuBudget.show();

        });
        btn_creatBuget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntentCreatBuget= new Intent(CreateBudgetEvent.this, ViewBudgetEvent.class);
                startActivity(myIntentCreatBuget);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater= getMenuInflater();
        inflater.inflate(R.menu.menu_budget,menu);
        return true;
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