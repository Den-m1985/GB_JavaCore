package com.example;


public class App {
    public static void main(String[] args) {

        // Создание объекта Person
        Person person = new Person("John", "Doe", 30);
        Person person2 = new Person("Jo", "Do", 3);

        // Сериализация в JSON
        String json = person.toJson();
        System.out.println("JSON: " + json);

        // Десериализация из JSON
        Person restoredPerson = Person.fromJson(json);
        System.out.println("Restored Person: " + restoredPerson);

        System.out.println("HashCode: " + person.hashCode());

        System.out.println(person.equals(person2));
    }

}
