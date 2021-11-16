package com.example.androidfundamentals2nov;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondMainActivityWeek5 extends AppCompatActivity {
    private final static String TAG = SecondMainActivityWeek5.class.getSimpleName();
    public final static String SECOND_MESSAGE_KEY = "second_key";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_main_week5);

        Bundle bundle = getIntent().getExtras();

        if (bundle != null) {
            String message = bundle.getString(MainActivityWeek5.MESSAGE_KEY);
            Person person = (Person) bundle.getSerializable(MainActivityWeek5.PERSON_KEY);
            String name = person.getName();

            Log.d(TAG, message + " " + name);

            TextView textView = (TextView) findViewById(R.id.message);
            String concatMessage = message + " " + name;
            textView.setText(concatMessage);
        }

        Button closeActivity = (Button) findViewById(R.id.finishActivity);
        closeActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra(SECOND_MESSAGE_KEY, "Hello back Roxana");
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }
}