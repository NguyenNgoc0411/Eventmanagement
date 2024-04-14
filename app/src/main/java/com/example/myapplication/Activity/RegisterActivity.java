package com.example.myapplication.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.myapplication.Object.User;
import com.example.myapplication.R;

import java.util.Calendar;

public class RegisterActivity extends AppCompatActivity {
    static final int MY_REQUEST_CODE = 10;

    //    private static final int MY_REQUEST_CODE =10 ;
    //    String[] itemDate={"01","02","03","04","06","07","08","09","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
//    String[] itemMonth={"01","02","03","04","05","06","07","08","09","10","11","12"};
//    String[] itemYear={"1970", "1971", "1972", "1973", "1974", "1975", "1976", "1977", "1978", "1979", "1980", "1981", "1982", "1983", "1984", "1985", "1986", "1987", "1988", "1989", "1990", "1991", "1992", "1993", "1994", "1995", "1996", "1997", "1998", "1999", "2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019", "2020"};
//    ArrayAdapter<String> adapterDate,adapterMonth,adapterYear;
//    AutoCompleteTextView datedrop,monthdrop,yeardrop;
    private DatePickerDialog datePickerDialog;
    private RadioButton rnam,rnu;
    private EditText edit_firstname, edit_lastname;
    private  Button dateButton;
    private Button btn_continue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


        edit_firstname=findViewById(R.id.first_name);
        edit_lastname=findViewById(R.id.last_name);
        rnam=findViewById(R.id.radioButtonNam);
        rnu=findViewById(R.id.radioButtonNu);
        initDatePiker();
        dateButton= findViewById(R.id.pickDate);

        dateButton.setText(getTodaysDate());


        btn_continue=findViewById(R.id.button_tieptheo);
        btn_continue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //khai báo intent thực hiện gọi
//                Intent myIntentRegister = new Intent(RegisterActivity.this, RegisterFinalActivity.class);
//                startActivity(myIntentRegister);
              nextActivity();
            }


        });
    }
    private void nextActivity() {



        String first_name= edit_firstname.getText().toString().trim();
        String last_name= edit_lastname.getText().toString().trim();
        User a= new User();
        a.setName(first_name+" "+last_name);
        if(rnam.isChecked()){
            a.setSex(rnam.getText().toString());
        }
        if(rnu.isChecked()){
            a.setSex(rnu.getText().toString());
        }
        a.setDate(dateButton.getText().toString());

        Intent intent= new Intent(RegisterActivity.this,RegisterFinalActivity.class);
        Bundle bundle= new Bundle();
        bundle.putSerializable("user",a);
        intent.putExtras(bundle);
        startActivityForResult(intent,MY_REQUEST_CODE);
    }


    private String getTodaysDate() {
        Calendar cal= Calendar.getInstance();
        int year= cal.get(Calendar.YEAR);
        int month= cal.get(Calendar.MONTH);
        int day= cal.get(Calendar.DAY_OF_MONTH);
        month=month+1;
        return makeDateString(day,month,year);
    }

    private void initDatePiker()
    { DatePickerDialog.OnDateSetListener dateSetListener= new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker datePicker, int year, int month, int dayOfMonth) {
            month=month+1;
            String date=makeDateString(dayOfMonth,month,year);
            dateButton.setText(date);

        }


    };
        Calendar cal= Calendar.getInstance();
        int year= cal.get(Calendar.YEAR);
        int month= cal.get(Calendar.MONTH);
        int day= cal.get(Calendar.DAY_OF_MONTH);
        int style= AlertDialog.THEME_HOLO_LIGHT;
        datePickerDialog= new DatePickerDialog(this,style,dateSetListener,year,month,day);


    }
    private String makeDateString(int dayOfMonth, int month, int year) {
        return dayOfMonth+"/ "+getMonthFormat(month)+"/ "+year;

    }

    private String getMonthFormat(int month) {
        if(month==1)
            return "01";
        if(month==2)
            return "02";
        if(month==3)
            return "03";
        if(month==4)
            return "04";
        if(month==5)
            return "05";
        if(month==6)
            return "06";
        if(month==7)
            return "07";
        if(month==8)
            return "08";
        if(month==9)
            return "09";
        if(month==10)
            return "10";
        if(month==11)
            return "11";

        return "12";

    }


    public void openDatePicker(View view) {
        datePickerDialog.show();
    }

    public void onradioclick(View view) {
        boolean checked= ((RadioButton) view).isChecked();
        String str="";
        switch (view.getId())
        {

        }
    }

    public void clickBack(View view) {

    }


//    private void dropDate() {
//        datedrop = findViewById(R.id.autoCompleteDate);
//        adapterDate= new ArrayAdapter<String>(this,R.layout.list_date,itemDate);
//
//        datedrop.setAdapter(adapterDate);
//        datedrop.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                String item1 = adapterView.getItemAtPosition(i).toString();
//
//                Toast.makeText(RegisterActivity.this,"date"+item1,Toast.LENGTH_SHORT).show();
//
//
//
//            }
//        });



}