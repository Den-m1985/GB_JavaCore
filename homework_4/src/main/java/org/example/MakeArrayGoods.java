package org.example;

import java.util.ArrayList;
import java.util.Random;

public class MakeArrayGoods {

    public ArrayList<Goods> createArrayGoods(int count) {
        ArrayList<Goods> goods = new ArrayList<>();
        Random random = new Random();

        String[] nameArray = {"Футболка", "Ноутбук", "Кофеварка", "Шорты", "Смартфон", "Наушники",
                "Книга", "Планшет", "Фитнес-трекер", "Кошелек"};


        for (int i = 0; i < count; i++) {

            int randomIndexName = random.nextInt(nameArray.length);
            String name = nameArray[randomIndexName];

            int price = random.nextInt(20, 100);

            Goods good = new Goods(name, price);
            goods.add(good);
        }
        return goods;
    }

}
