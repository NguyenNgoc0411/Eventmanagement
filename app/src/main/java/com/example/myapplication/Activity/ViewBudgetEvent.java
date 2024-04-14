package com.example.myapplication.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myapplication.R;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.button.MaterialButton;

public class ViewBudgetEvent extends AppCompatActivity {
    Button button_NH;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_budget_event);
        button_NH = findViewById(R.id.buttonnhahang);
        button_NH.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDialog(Gravity.BOTTOM);

            }
        });


    }
    private void openDialog(int gravity){
        final Dialog dialog1=new Dialog(this);
        dialog1.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog1.setContentView(R.layout.update_budget_dialog);
        Window window= dialog1.getWindow();
        if(window==null){
            return;
        }
        window.setLayout(WindowManager.LayoutParams.MATCH_PARENT,WindowManager.LayoutParams.WRAP_CONTENT);
        window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        WindowManager.LayoutParams windowAttributes = window.getAttributes();
        windowAttributes.gravity=gravity;
        window.setAttributes(windowAttributes);
        if(Gravity.BOTTOM==gravity){
            dialog1.setCancelable(true);
        }
        else {
            dialog1.setCancelable(false);
        }
        EditText editNCC=dialog1.findViewById(R.id.editBudget_NCC);
        EditText editBonus= dialog1.findViewById(R.id.editBudget_Bonus);
        EditText editDescribe= dialog1.findViewById(R.id.editBudget_Describe);
        Button buttonUpdate=dialog1.findViewById(R.id.button_update);
        buttonUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog1.dismiss();
            }
        });
        dialog1.show();
    }

}