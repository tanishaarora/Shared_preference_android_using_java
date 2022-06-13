package com.example.newapp;

public class ListModel {
    private String name;
    private String city;
    private Integer age;
    private Integer dob;
    public ListModel(String nam, Integer ag, String cit, Integer dov) {
        this.name = nam;
        this.age = ag;
        this.city = cit;
        this.dob = dov;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getDob() {
        return dob;
    }

    public void setDob(Integer dob) {
        this.dob = dob;
    }
}
