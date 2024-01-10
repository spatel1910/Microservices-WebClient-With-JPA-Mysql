package com.employee.model;

import jakarta.persistence.*;
/*
This class will act as model which we also call entity
To let springboot that this is object is going to travel to the database
add @Entity , and tell which Table to map with @Table
Make sure you have all the fields as you have in table
make sure properties are in the same order and table column
*/

@Entity
@Table(name = "employee")
public class Employee {
    @Id
    private int id;
    private String name;

    public Employee() {
    }

    private String email;

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

    private int age;

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                '}';
    }

    public Employee(int id, String name, String email, int age) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.age = age;
    }
}
