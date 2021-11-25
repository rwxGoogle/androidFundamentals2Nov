package com.example.androidfundamentals2nov.week8;

import android.content.Context;

import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;

@androidx.room.Database(entities = {PersonEntity.class}, version = 2)
public abstract class Database extends RoomDatabase {
    private final static String MY_DATABASE = "my_database";

    public abstract PersonDao personDao();

    private static Database DATABASE;

    static final Migration MIGRATION1_2 = new Migration(1, 2) {

        @Override
        public void migrate(SupportSQLiteDatabase database) {
            database.execSQL("ALTER TABLE Person " + " ADD COLUMN nickName TEXT");
        }
    };

    public static Database getDatabase(Context context) {
        if (DATABASE == null) {
            DATABASE = Room.databaseBuilder(context,
                    Database.class,
                    MY_DATABASE)
                    .addMigrations(MIGRATION1_2)
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return DATABASE;
    }

}