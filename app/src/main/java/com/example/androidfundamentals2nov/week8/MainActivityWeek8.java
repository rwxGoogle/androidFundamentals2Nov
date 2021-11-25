package com.example.androidfundamentals2nov.week8;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;

import com.example.androidfundamentals2nov.DataSource;
import com.example.androidfundamentals2nov.Person;
import com.example.androidfundamentals2nov.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivityWeek8 extends AppCompatActivity {
    private static final String TAG = MainActivityWeek8.class.getSimpleName();
    private static final String ANDROID_FUNDAMENTALS_TEST = "test";
    private static final String NAME = "name";
    private String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_week8);

        name = getNameInSharedPreference();

        //Log.d(TAG, "My name is set: " + name);

        if (name.isEmpty()) {
           // Log.d(TAG, "My name is not set: " + name);
            saveNameInSharedPreference("Roxana");
        }


        ArrayList<PersonEntity> personEntities = new ArrayList<>();

        List<Person> personList = new DataSource().getPersons();

        for (Person person : personList) {
            personEntities.add(new PersonEntity(
                    person.getName(),
                    "No Surname",
                    person.getCountry(),
                    "nickName"
            ));
        }

        new Thread() {
            @Override
            public void run() {
//                for (PersonEntity personEntity : personEntities) {
//                    Database.getDatabase(MainActivityWeek8.this).personDao().insertPerson(personEntity);
//                }

                Database.getDatabase(MainActivityWeek8.this).personDao().insertPersons(personEntities);

                List<PersonEntity> persons = Database.getDatabase(MainActivityWeek8.this).personDao().getAllPersons();
                for (PersonEntity personEntity : persons) {
                    Log.d(TAG, "Person entity name is: " + personEntity.name);
                }

                String name = Database.getDatabase(MainActivityWeek8.this).personDao().getPersonByName("Roxana").name;
                Log.d(TAG, "My name is: " + name);
            }
        }.start();

    }


    private void saveNameInSharedPreference(String name) {
        SharedPreferences sharedPreferences = this.getSharedPreferences(ANDROID_FUNDAMENTALS_TEST, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(NAME, name);
        editor.apply();
    }

    private String getNameInSharedPreference() {
        SharedPreferences sharedPreferences = this.getSharedPreferences(ANDROID_FUNDAMENTALS_TEST, Context.MODE_PRIVATE);
        return sharedPreferences.getString(NAME, "");
    }
}