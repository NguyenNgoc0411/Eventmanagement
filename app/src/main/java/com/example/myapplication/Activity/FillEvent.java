package com.example.myapplication.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.myapplication.DAO.DAO;
import com.example.myapplication.Object.AddressOrganization;
import com.example.myapplication.Object.Event;
import com.example.myapplication.R;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class FillEvent extends AppCompatActivity {
    private AutoCompleteTextView autoCompleteTextCity;
    private Button creatEvent,getDate,setHour,setDateEnd,setHourEnd;
    private EditText editEventName,editTextStreet,editTextDescribe;
    private DatePickerDialog datePickerDialog,dateEndDialog;
    private  TimePickerDialog timePickerDialog,timeEndDialog;

    private List<AddressOrganization> eventAddress;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        eventAddress=new ArrayList<>();
        setContentView(R.layout.activity_fill_event);
        creatEvent=findViewById(R.id.button_createEvent);
        autoCompleteTextCity=findViewById(R.id.editTextStreet);

        getDate= findViewById(R.id.button_setDate);
        setHour=findViewById(R.id.button_setHour);
        setDateEnd=findViewById(R.id.button_setDate_end);
        setHourEnd=findViewById(R.id.button_setHour_end);
        getDate.setText(getToDayDate());
        setHour.setText(getTime());
        setHourEnd.setText(getTime());
        setDateEnd.setText(getToDayDate());
        initDatePiker();
        initTimePicker();
        initDateEndPiker();
        initTimeEndPicker();
        DAO dao= new DAO();
        dao.getAddressOrganization(eventAddress);



        creatEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //khai báo intent thực hiện gọi
//                Intent myIntentRegister = new Intent(FillEvent.this, CreateBudgetEvent.class);
//                startActivity(myIntentRegister);
//
                creatnewevent();

            }


        });
        autoCompleteTextCity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                findaddressevent();
            }
        });
    }

    private void findaddressevent() {

        ArrayList<String> x= new ArrayList<>();

        for(AddressOrganization a: eventAddress)
        {
            x.add(a.getName()+"\n"+a.getAddress());
        }



        ArrayAdapter<String> arrayAdapter= new ArrayAdapter<>(FillEvent.this, R.layout.layout_custom,R.id.textviewAddrress,x);


        autoCompleteTextCity.setAdapter(arrayAdapter);



    }

    private String getTime() {
        Calendar calendar= Calendar.getInstance();
        int hour= calendar.get(Calendar.HOUR);
        int minutes=calendar.get(Calendar.MINUTE);
        if(minutes<10)
            return hour+":0"+minutes;
        return hour+":"+minutes;

    }


    private String getToDayDate() {
        Calendar cal= Calendar.getInstance();
        int year= cal.get(Calendar.YEAR);
        int month= cal.get(Calendar.MONTH);
        int day= cal.get(Calendar.DAY_OF_MONTH);
        month=month+1;
        return makeDateString(day,month,year);
    }

    private String makeDateString(int dayOfMonth, int month, int year) {
        return dayOfMonth+"/"+getMonthFormat(month)+"/"+year;
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
    private void initDatePiker()
    { DatePickerDialog.OnDateSetListener dateSetListener= new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker datePicker, int year, int month, int dayOfMonth) {
            month=month+1;
            String date=makeDateString(dayOfMonth,month,year);
            getDate.setText(date);

        }


    };
        Calendar cal= Calendar.getInstance();
        int year= cal.get(Calendar.YEAR);
        int month= cal.get(Calendar.MONTH);
        int day= cal.get(Calendar.DAY_OF_MONTH);
        int style= AlertDialog.THEME_HOLO_LIGHT;
        datePickerDialog= new DatePickerDialog(this,R.style.DialogTheme,dateSetListener,year,month,day);


    }
    private void initDateEndPiker()
    { DatePickerDialog.OnDateSetListener dateSetListener= new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker datePicker, int year, int month, int dayOfMonth) {
            month=month+1;
            String date=makeDateString(dayOfMonth,month,year);
            setDateEnd.setText(date);

        }


    };
        Calendar cal= Calendar.getInstance();
        int year= cal.get(Calendar.YEAR);
        int month= cal.get(Calendar.MONTH);
        int day= cal.get(Calendar.DAY_OF_MONTH);
        int style= AlertDialog.THEME_HOLO_LIGHT;
        dateEndDialog= new DatePickerDialog(this,R.style.DialogTheme,dateSetListener,year,month,day);


    }

    public void setDateEvent(View view) {
        datePickerDialog.show();
    }

    public void initTimePicker() {
        TimePickerDialog.OnTimeSetListener dataSetListener= new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hours, int minute) {

                setHour.setText(String.valueOf((hours))+":"+String.valueOf(minute));

            }
        };

            Calendar calendar= Calendar.getInstance();
            int hour= calendar.get(Calendar.HOUR);
            int minutes=calendar.get(Calendar.MINUTE);
            timePickerDialog= new TimePickerDialog(this,R.style.DialogTheme,dataSetListener,hour,minutes,true);


        }
    public void initTimeEndPicker() {
        TimePickerDialog.OnTimeSetListener dataSetListener= new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hours, int minute) {

                setHourEnd.setText(String.valueOf((hours))+":"+String.valueOf(minute));

            }
        };

        Calendar calendar= Calendar.getInstance();
        int hour= calendar.get(Calendar.HOUR);
        int minutes=calendar.get(Calendar.MINUTE);
        timeEndDialog= new TimePickerDialog(this,R.style.DialogTheme,dataSetListener,hour,minutes,true);


    }



    public void setTimePicker(View view) {
        timePickerDialog.show();
    }

    public void setTimeEndPicker(View view) {
        timeEndDialog.show();
    }

    public void setDateEndEvent(View view) {
        dateEndDialog.show();
    }
    private void creatnewevent() {
        Event eventnew= new Event();
        String nameEvent= editEventName.getText().toString().trim();
        String dateBegin= getDate.getText().toString().trim();
        String timeBegin= setHour.getText().toString().trim();
        String dateEnd= setDateEnd.getText().toString().trim();
        String timeEnd= setHourEnd.getText().toString().trim();
        String describe= editTextDescribe.getText().toString().trim();
        String textAddress=autoCompleteTextCity.getText().toString().trim();
        boolean check=true;
        if(nameEvent.isEmpty())
        {
            editEventName.setError("Vui lòng điền thông tin");
            check=false;
        }
       if(textAddress.isEmpty()||textAddress.equals("Địa điểm tổ chức"))
       {
           autoCompleteTextCity.setText("Vui lòng chọn địa điểm");
           check=false;
       }
       if(check==true)
       {

       }





    }
    private void showDialogWarning(int gravity,int c) {
        final Dialog dialog1=new Dialog(this);
        dialog1.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog1.setContentView(R.layout.alert_dialog);
        TextView x= dialog1.findViewById(R.id.textViewAlert);
        if(c==0)
        {
            x.setText("Lỗi ngày giờ");
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
                    Intent intent = new Intent(FillEvent.this,Login.class);
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
}
