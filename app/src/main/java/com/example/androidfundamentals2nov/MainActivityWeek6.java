package com.example.androidfundamentals2nov;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import com.example.androidfundamentals2nov.databinding.ActivityMainWeek6Binding;

public class MainActivityWeek6 extends AppCompatActivity implements NameListener {
    private static final String TAG = "DEBUG RWX " + MainActivityWeek6.class.getSimpleName();
    public static String PERSON_KEY = "person_key";
    private FragmentWeek6 fragmentWeek6;
    private TextView tvName;

    //TODO View Binding
    private ActivityMainWeek6Binding activityMainWeek6Binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_week6);

//        activityMainWeek6Binding = ActivityMainWeek6Binding.inflate(getLayoutInflater());
//        setContentView(activityMainWeek6Binding.getRoot());
        //activityMainWeek6Binding.activityName.setText("Roxana"):

        tvName = findViewById(R.id.activityName);

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentWeek6 = new FragmentWeek6();
        Bundle bundle = new Bundle();
        Person person = new Person();
        person.setName("Roxana");
        bundle.putSerializable(PERSON_KEY, person);
        fragmentWeek6.setArguments(bundle);

        fragmentTransaction.replace(R.id.placeholder, fragmentWeek6, FragmentWeek6.class.getSimpleName());
        fragmentTransaction.commit();
    }

    @Override
    protected void onStart() {
        super.onStart();

        Log.d(TAG, "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();

        Log.d(TAG, "onResume");

        // fragmentWeek6 = (FragmentWeek6) getSupportFragmentManager().findFragmentById(R.id.staticFragment);
        fragmentWeek6 = (FragmentWeek6) getSupportFragmentManager().findFragmentByTag(FragmentWeek6.class.getSimpleName());
        fragmentWeek6.setName("Roxana");


    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }

    @Override
    protected void onPause() {
        super.onPause();

        Log.d(TAG, "onPause");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        Log.d(TAG, "onDestroy");
    }

    @Override
    public void addName(String name) {
        tvName.setText(name);
    }

    @Override
    public void onBackPressed() {
        Log.d(TAG, "onBackPressed");
        super.onBackPressed();
    }
}