package com.monzag.checkpoint4;

public class Customer {

    Integer id;
    String name;
    String surname;
    Integer birthyear;
    String gender;


    public Customer(Integer id, String name, String surname, Integer birthyear, String gender) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.birthyear = birthyear;
        this.gender = gender;
    }

    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", birthyear=" + birthyear +
                ", gender='" + gender + '\'' +
                '}';
    }
}