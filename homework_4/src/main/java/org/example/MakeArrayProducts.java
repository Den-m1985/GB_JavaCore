package org.example;

import java.util.ArrayList;

public class MakeArrayProducts {

    public ArrayList<Product> createArrayProducts() {
        ArrayList<Product> products = new ArrayList<>();

        Product product = new Product("Футболка", 20);
        products.add(product);
        Product product2 = new Product("Ноутбук", 30);
        products.add(product2);
        Product product3 = new Product("Кофеварка", 40);
        products.add(product3);
        Product product4 = new Product("Шорты", 50);
        products.add(product4);
        Product product5 = new Product("Смартфон", 60);
        products.add(product5);

        return products;
    }

}
