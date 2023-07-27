package org.example;

public class Buyer {
    private String name;
    private String secondName;
    private String patronymic;
    private String phoneNumber;
    private int age;

    public Buyer(String name, String secondName, String patronymic, String phoneNumber, int age) {
        this.name = name;
        this.secondName = secondName;
        this.patronymic = patronymic;
        this.phoneNumber = phoneNumber;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Buyer: " +
                "name= " + name +
                ", secondName= " + secondName +
                ", patronymic= " + patronymic  +
                ", phoneNumber= " + phoneNumber+
                ", age= " + age;
    }
}
