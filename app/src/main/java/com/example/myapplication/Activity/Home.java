package com.example.myapplication.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.ListFragment;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.myapplication.Fragment.HomeFragment;
import com.example.myapplication.Fragment.PersonalFragment;
import com.example.myapplication.Object.User;
import com.example.myapplication.R;
import com.example.myapplication.Fragment.SettingFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Home extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        bottomNavigationView = findViewById(R.id.navigation);
        Fragment homeFragment = new HomeFragment();
        Fragment settingFragment = new SettingFragment();
        Fragment listFragment = new ListFragment();
        Fragment personalFragment = new PersonalFragment();
        User userLogin= new User();

        if(getIntent().getExtras()!=null)
        {
            userLogin= (User) getIntent().getExtras().get("userLogin");

        }
        Bundle bundle= new Bundle();
        bundle.putSerializable("userLoginComplete",userLogin);
        homeFragment.setArguments(bundle);
        settingFragment.setArguments(bundle);
        listFragment.setArguments(bundle);
        personalFragment.setArguments(bundle);


        setFragmentCurrent(homeFragment);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                if (id == R.id.home_navi){

//                    homeFragment.setArguments(bundle);
                    setFragmentCurrent(homeFragment);
                    return true;
                }
                if (id == R.id.setting_navi){
                    setFragmentCurrent(settingFragment);
                    return true;
                }
                if(id == R.id.list_navi){
                    setFragmentCurrent(listFragment);
                    return true;
                }
                if(id == R.id.personal_navi){
                    setFragmentCurrent(personalFragment);
                    return true;
                }
                return false;
            }
        });

    }


    public void a(){
        Toast.makeText(this, "123", Toast.LENGTH_SHORT).show();
    }

    public void setFragmentCurrent(Fragment fragment){
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_main, fragment)
                .commit();
    }
}