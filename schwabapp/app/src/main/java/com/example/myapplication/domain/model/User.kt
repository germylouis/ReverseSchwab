package com.example.myapplication.domain.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

    @Entity(tableName = "User")
    data class User(
        @PrimaryKey(autoGenerate = true)
        @ColumnInfo(name = "user_id")
        var id: Int,

        @SerializedName("name")
        @ColumnInfo(name = "user_name")
        var name : String,

        @SerializedName("password")
        @ColumnInfo(name = "user_pass")
        var email : String
    )

