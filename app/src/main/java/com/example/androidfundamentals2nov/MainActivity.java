package com.example.androidfundamentals2nov;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.SearchView;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private final String TAG = MainActivity.class.getSimpleName();
    private String email = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView authTitle = (TextView) findViewById(R.id.authentificationTitle);
        authTitle.setText("Authentication");

        ImageView imageView = (ImageView) findViewById(R.id.imageView);

        Button loginButton = (Button) findViewById(R.id.loginButton);
        EditText emailAddress = (EditText) findViewById(R.id.emailAddress);
        RatingBar ratingBar = (RatingBar) findViewById(R.id.ratingBar);

        ProgressBar progressBar = (ProgressBar) findViewById(R.id.progressCircular);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "Login Button was clicked");
                if (imageView.getVisibility() == View.VISIBLE)
                    imageView.setVisibility(View.INVISIBLE);
                else imageView.setVisibility(View.VISIBLE);

//                if(email.isEmpty()){
//                    emailAddress.setError("Email Address should not be empty!");
//                }

                if (emailAddress.getText().toString().isEmpty()) {
                    emailAddress.setError("Email Address should not be empty!");
                }

                ratingBar.setRating(7);

                if (progressBar.getVisibility() == View.VISIBLE)
                    progressBar.setVisibility(View.GONE);
                else progressBar.setVisibility(View.VISIBLE);

            }
        });

        emailAddress.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                Log.d(TAG, "beforeTextChanged() text= " + s);
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Log.d(TAG, "onTextChanged() text= " + s);
            }

            @Override
            public void afterTextChanged(Editable s) {
                Log.d(TAG, "afterTextChanged() text= " + s);
                email = s.toString();
            }
        });

        CheckBox rememberMe = (CheckBox) findViewById(R.id.rememberMe);
        rememberMe.setText("Remember Me");
        rememberMe.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Log.d(TAG, "onCheckedChanged() isChecked= " + isChecked);
            }
        });

        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                Log.d(TAG, "onCheckedChanged() checkedId= " + checkedId);
                RadioButton radioButton = findViewById(checkedId);
                Log.d(TAG, "onCheckedChanged()" + radioButton.getText().toString());
            }
        });


        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                Log.d(TAG, "onRatingChanged rating= " + rating + "fromUser= " + fromUser);
            }
        });

        SeekBar seekBar = (SeekBar) findViewById(R.id.seekBar);
        seekBar.setProgress(60);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                Log.d(TAG, "onProgressChanged() progress= " + progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                Log.d(TAG, "onStartTrackingTouch()");
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Log.d(TAG, "onStopTrackingTouch()");
            }
        });

        SwitchCompat notifications = (SwitchCompat) findViewById(R.id.notificationSwitch);
        notifications.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Log.d(TAG, "onCheckedChanged() isChecked= " + isChecked);
            }
        });

        SearchView searchView = (SearchView) findViewById(R.id.searchView);
        searchView.setQuery("", false);
    }
}