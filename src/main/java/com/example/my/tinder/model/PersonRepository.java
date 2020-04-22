package com.example.my.tinder.model;


import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class PersonRepository {


    static Person gosha = new Person(0, "Gosha", "Moskito", "565321951", "Piter",
            Gender.MALE, "gosha@gmail.com", 31, "master", 7);
    static Person vasia = new Person(1, "Vasia", "Pupkov", "123654789", "Lipsk",
            Gender.MALE, "vasia@gmail.com", 23, "high school graduate", 4);
    static Person katya = new Person(2, "Katya", "Ivong", "789456123", "Saratov",
            Gender.FEMALE, "katya@gmail.com", 22, "associate", 5);
    static Person lena = new Person(3, "Lena", "Baladaj", "456321987", "Moskov",
            Gender.FEMALE, "lena@gmail.com", 55, "bachelor", 78);
    static Person tolya = new Person(4, "Tolya", "Dru", "258369147", "Gorlovka",
            Gender.MALE, "tolya@gmail.com", 18, "High school", 98);
    static Person valentyn = new Person(5, "Valentyn", "Rak", "1597753852", "Tomsk",
            Gender.MALE, "valentyn@gmail.com", 32, "master", 5);
    static Person natalia = new Person(6, "Natalia", "Grom", "456987123", "Vladivostok",
            Gender.FEMALE, "natalia@gmail.com", 28, "college", 12);
    static Person maria = new Person(7, "Maria", "Zuchova", "316497852", "Machachkala",
            Gender.FEMALE, "maria@gmail.com", 21, "bachelor", 14);
    static Person boris = new Person(8, "Boris", "Sokol", "852369741", "Donetsk",
            Gender.MALE, "boris@gmail.com", 29, "doctoral", 6);
    static Person helga = new Person(9, "Helga", "Glad", "149632578", "Drezden",
            Gender.OUTOFGENDER, "helga@gmail.com", 36, "college", 30);

    static final Person protagonist = new Person(10, "Protagonist", "Delan", "598732146", "Cracow",
            Gender.FEMALE, "protagonist@gmail.com", 47, "master", 25);


    static List<Person> people = new ArrayList<>();

    static {
        people.add(gosha);
        people.add(vasia);
        people.add(katya);
        people.add(lena);
        people.add(tolya);
        people.add(valentyn);
        people.add(natalia);
        people.add(maria);
        people.add(boris);
        people.add(helga);
        people.add(protagonist);
    }


    public List<Person> findAllPeople() {
        return people;
    }

    public List<Person> findByAge(int from, int to) {
        return people.stream().filter((person -> person.getAge() > from & person.getAge() < to))
                .collect(Collectors.toList());
    }


    public List<Person> findById(int id) {
        return people.stream().filter(person -> person.getId() == id)
                .collect(Collectors.toList());
    }

    public Person createPerson(int id, String name, String surname) {
        Person person = new Person();
        person.setId(id);
        person.setName(name);
        person.setSurname(surname);
        return person;
    }


   /* List<Person> findByGender(Gender) {
        return people.stream().filter(person -> person.getGender(GE))
    }*/

}
