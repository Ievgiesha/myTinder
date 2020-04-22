package com.example.my.tinder.model;


import org.springframework.data.annotation.Id;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

@Entity
@Table(name = "person")
public class Person {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private int id;
    @Size(min = 3, max = 50)
    private String name;
    private String surname;
    private String phoneNumber;
    private String address;
    private Gender gender;
    @Email
    private String email;
    private int age;
    private String education;
    private long activity;

    Person(int id, String name, String surname, String phoneNumber, String address, Gender gender, String email,
           int age, String education, long activity) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.gender = gender;
        this.email = email;
        this.age = age;
        this.education = education;
        this.activity = activity;
    }

    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

public Person (){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

     public Gender getGender(){ return gender ; }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public long getActivity() {
        return activity;
    }

    public void setActivity(long activity) {
        this.activity = activity;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }


    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", address='" + address + '\'' +
                ", gender=" + gender +
                ", email='" + email + '\'' +
                ", age=" + age +
                ", education='" + education + '\'' +
                ", activity=" + activity +
                '}';
    }
}
