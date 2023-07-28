package org.example;

import java.util.ArrayList;

public class makeArrayOrders {

    public ArrayList<Order> createArrayOrders(int count) {

        ArrayList<Order> orders = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            Order order = new Order(null, null, 10);
            orders.add(order);
        }
        return orders;
    }

}
