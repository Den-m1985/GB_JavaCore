package org.example;

import java.util.ArrayList;
import java.util.Random;

public class MakeArrayBuyer {

    public ArrayList<Buyer> createArrayBuyer(int count) {
        ArrayList<Buyer> buyer = new ArrayList<>();
        Random random = new Random();
        /*
       private String name;
        private String secondName;
        private String patronymic;
        private String phoneNumber;
        private int age;
        */
        String[] nameArray = {"John", "Emma", "Liam", "Olivia", "Noah", "Ava", "William", "Sophia", "James", "Isabella"};
        String[] secondNameArray = { "Smith", "Johnson", "Williams", "Brown", "Jones", "Garcia", "Miller", "Davis"};
        String[] patronymicArray = { "Johnson", "Williamson", "Brownson", "Joneson", "Garcias", "Millers", "Davison",
                "Rodriguezson", "Martinezon" };

        for (int i = 0; i < count; i++) {
            int randomIndexName = random.nextInt(nameArray.length);
            String name = nameArray[randomIndexName];

            int randomIndexSurname = random.nextInt(secondNameArray.length);
            String secondName = secondNameArray[randomIndexSurname];

            int randomIndexPatronymic = random.nextInt(patronymicArray.length);
            String patronymic = patronymicArray[randomIndexPatronymic];


            int rand1 = random.nextInt(1000000, 9999999);
            String phoneNumber = "+79" + rand1;

            int age = random.nextInt(20, 90);

            Buyer buy = new Buyer(name, secondName, patronymic, phoneNumber, age);
            buyer.add(buy);
        }
        return buyer;
    }
}
