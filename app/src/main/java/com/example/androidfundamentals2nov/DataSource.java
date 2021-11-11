package com.example.androidfundamentals2nov;

import java.util.ArrayList;
import java.util.List;

public class DataSource {

    public List<Person> getPersons() {
        Person person1 = new Person();
        person1.setName("Raluca");
        person1.setCountry("Cluj");
        person1.setAge("22");

        Person person2 = new Person();
        person2.setName("Dragos");
        person2.setCountry("Brasov");
        person2.setAge("25");


        Person person3 = new Person();
        person3.setName("Paul");
        person3.setCountry("Bucuresti");
        person3.setAge("12");


        Person person4 = new Person();
        person4.setName("Raluca");
        person4.setCountry("Cluj");
        person4.setAge("22");

        Person person5 = new Person();
        person5.setName("Dragos");
        person5.setCountry("Brasov");
        person5.setAge("25");


        Person person6 = new Person();
        person6.setName("Paul");
        person6.setCountry("Bucuresti");
        person6.setAge("12");

        Person person7 = new Person();
        person7.setName("Paul");
        person7.setCountry("Bucuresti");
        person7.setAge("12");

        Person person8 = new Person();
        person8.setName("Paul");
        person8.setCountry("Bucuresti");
        person8.setAge("12");

        List<Person> persons = new ArrayList<>();
        persons.add(person1);
        persons.add(person2);
        persons.add(person3);
        persons.add(person4);
        persons.add(person5);
        persons.add(person6);
        persons.add(person7);
        persons.add(person8);

        return persons;
    }


}
