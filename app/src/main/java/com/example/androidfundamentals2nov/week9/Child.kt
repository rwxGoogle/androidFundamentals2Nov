package com.example.androidfundamentals2nov.week9

import com.google.gson.annotations.SerializedName

class Child {
    @SerializedName("firstname")
    var firstName: String = ""

    @SerializedName("lastname")
    var surName: String = ""
}