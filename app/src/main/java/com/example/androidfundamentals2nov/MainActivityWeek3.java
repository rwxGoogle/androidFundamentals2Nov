package com.example.androidfundamentals2nov;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class MainActivityWeek3 extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private static final String URL = "https://www.google.com/";
    private final String TAG = MainActivityWeek3.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_week3);

        WebView webView = (WebView) findViewById(R.id.webView);
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        webView.loadUrl(URL);


        Spinner spinner = (Spinner) findViewById(R.id.books);

        ArrayAdapter<String> adapter = getAdapter();

        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

    }

    private List<String> getBooks() {
        List<String> books = new ArrayList<>();
        books.add("Book1");
        books.add("Book2");
        books.add("Book3");
        books.add("Book4");

        return books;
    }

    private ArrayAdapter<String> getAdapter() {
        String[] books = getResources().getStringArray(R.array.books);
        return new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, books);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Log.d(TAG, "onItemSelected() position= " + position);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        Log.d(TAG, "onNothingSelected()");
    }
}