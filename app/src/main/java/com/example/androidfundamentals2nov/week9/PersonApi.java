package com.example.androidfundamentals2nov.week9;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface PersonApi {

    @GET("rwxGoogle/androidFundamentals2Nov/master/{fileName}")
    Call<List<User>> getUsers(@Path("fileName") String jsonToFetch);
}
