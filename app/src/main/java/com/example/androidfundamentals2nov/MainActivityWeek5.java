package com.example.androidfundamentals2nov;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.TextView;

import com.google.android.material.switchmaterial.SwitchMaterial;

import org.w3c.dom.Text;

public class MainActivityWeek5 extends AppCompatActivity {
    private final String TAG = MainActivityWeek5.class.getSimpleName();
    public final static String PERSON_KEY = "person";
    public final static String MESSAGE_KEY = "key";
    private final static String REMEMBER_ME_KEY = "remember_me_key";
    private final static String TEXT_KEY = "text_key";

    private Boolean isRememberMeChecked = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_week5);

        Log.d(TAG, "onCreate");

        TextView tvMessage = (TextView) findViewById(R.id.message);

        ActivityResultLauncher<Intent> startActivityForResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
            @Override
            public void onActivityResult(ActivityResult result) {
                if (result.getResultCode() == RESULT_OK) {
                    Log.d(TAG, "RESULT_OK");
                    Intent intent = result.getData();
                    if (intent != null) {
                        Bundle bundle = intent.getExtras();
                        String message = bundle.getString(SecondMainActivityWeek5.SECOND_MESSAGE_KEY);
                        tvMessage.setText(message);

                    }

                } else {
                    Log.d(TAG, "RESULT_CANCELED");
                }
            }
        });

        Button openBrowser = (Button) findViewById(R.id.openBrowser);
        openBrowser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // start activity using IMPLICIT INTENT
//                Intent intent = new Intent(Intent.ACTION_VIEW);
//                intent.setData(Uri.parse("https://www.google.com/"));
//                startActivity(intent);

                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:123456"));
                startActivity(intent);
            }
        });

        Button openSecondActivity = (Button) findViewById(R.id.openSecondActivity);
        openSecondActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // start activity using EXPLICIT INTENT
                Intent intent = new Intent(MainActivityWeek5.this, SecondMainActivityWeek5.class);
                Person person = new Person();
                person.setName("Roxana");
                intent.putExtra(PERSON_KEY, person);
                intent.putExtra(MESSAGE_KEY, "HELLO");
                startActivity(intent);
            }
        });

        Button openSecondActivityForResult = (Button) findViewById(R.id.openSecondActivityForResult);
        openSecondActivityForResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivityWeek5.this, SecondMainActivityWeek5.class);
                Person person = new Person();
                person.setName("Roxana");
                intent.putExtra(PERSON_KEY, person);
                intent.putExtra(MESSAGE_KEY, "HELLO");
                startActivityForResult.launch(intent);
            }
        });

        SwitchMaterial rememberMe = (SwitchMaterial) findViewById(R.id.rememberMe);

        rememberMe.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                isRememberMeChecked = isChecked;
            }
        });

        if (savedInstanceState != null) {
            boolean rememberMeState = savedInstanceState.getBoolean(REMEMBER_ME_KEY);
            Log.d(TAG, "savedInstanceState is not null  isRememberMeChecked= " + rememberMeState);
            rememberMe.setChecked(rememberMeState);
        } else {
            Log.d(TAG, "savedInstanceState is null  isRememberMeChecked= " + isRememberMeChecked);
        }


        TextView messageSaveInstanceState = (TextView) findViewById(R.id.messageSaveInstanceState);
        if (savedInstanceState != null) {
            String newMessage = savedInstanceState.getString(TEXT_KEY);
            messageSaveInstanceState.setText(newMessage);
        } else {
            messageSaveInstanceState.setText("Hello");
        }

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
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        Log.d(TAG, "onSaveInstanceState()");
        outState.putBoolean(REMEMBER_ME_KEY, isRememberMeChecked);
        outState.putString(TEXT_KEY, "hello new text here");
        super.onSaveInstanceState(outState);
    }
}