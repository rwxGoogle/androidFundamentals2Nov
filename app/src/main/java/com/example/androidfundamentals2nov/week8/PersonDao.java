package com.example.androidfundamentals2nov.week8;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Transaction;
import androidx.room.Update;

import java.util.List;

@Dao
public abstract class PersonDao {

    @Query("SELECT * FROM Person")
    public abstract List<PersonEntity> getAllPersons();

    @Query("SELECT * FROM Person WHERE name is :personName")
    public abstract PersonEntity getPersonByName(String personName);

    @Transaction
    public void insertPersons(List<PersonEntity> personList) {
        deleteAll();
        insertThePersons(personList);
    }

    @Insert
    public abstract void insertThePersons(List<PersonEntity> personEntityList);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public abstract void insertPerson(PersonEntity person);

    @Query("DELETE FROM Person")
    public abstract void deleteAll();

    @Update
    public abstract void updatePersons(List<PersonEntity> personEntityList);

    @Delete
    public abstract void delete(PersonEntity person);

}