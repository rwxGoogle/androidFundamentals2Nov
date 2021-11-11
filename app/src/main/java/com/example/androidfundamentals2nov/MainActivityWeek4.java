package com.example.androidfundamentals2nov;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MainActivityWeek4 extends AppCompatActivity {
    private final String TAG = MainActivityWeek4.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_week4);

        //define linear layout manager for recycler view (define views to be vertical aligned)
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.personsView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);

        //get data source
        List<Person> personList = new DataSource().getPersons();

        //set adapter
        PersonsAdapter personsAdapter = new PersonsAdapter(personList);
        recyclerView.setAdapter(personsAdapter);

    }
}