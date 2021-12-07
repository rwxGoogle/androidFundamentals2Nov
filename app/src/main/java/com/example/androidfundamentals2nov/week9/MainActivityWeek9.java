package com.example.androidfundamentals2nov.week9;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.example.androidfundamentals2nov.R;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivityWeek9 extends AppCompatActivity {
    private static final String BASE_URL = "https://raw.githubusercontent.com/";
    private static final String FIRST_FILE = "test_json1";
    private static final String SECOND_FILE = "test_json2";
    private static Retrofit retrofit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_week9);

        PersonApi api = getRetrofit().create(PersonApi.class);
        Call<List<User>> persons = api.getUsers(FIRST_FILE);
        persons.enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                if (response.isSuccessful()) {
                    Log.d("Response", response.body().toString());
                    Log.d("Response code", String.valueOf(response.code()));

                    List<User> users = response.body();

                    for (User user : users) {
                        String childName = user.getChild().getFirstName();
                        Log.d("Response", "Username= " + user.getName() + " childName= " + childName);
                    }

                } else {
                    Log.d("Response", "Response code " + response.code());
                }
            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {
                Log.w("Response", "Error in call", t);
            }
        });
    }

    public static Retrofit getRetrofit() {
        // Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ").create();
        // Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    //.addConverterFactory(GsonConverterFactory.create(gson))
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return retrofit;
    }
}