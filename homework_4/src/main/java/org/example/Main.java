package org.example;

import org.example.exceptions.AmountException;
import org.example.exceptions.CustomerException;
import org.example.exceptions.ProductException;

import java.util.ArrayList;

public class Main {
    private static ArrayList<Buyer> buyer;
    private static ArrayList<Product> arrayProducts;
    private static ArrayList<Order> arrayOrders;

    public static void main(String[] args) {

        buyer = new MakeArrayBuyer().createArrayBuyer();
        //buyer.forEach(bur -> System.out.println(bur.toString()));

        arrayProducts = new MakeArrayProducts().createArrayProducts();
        //arrayProducts.forEach(product -> System.out.println(product.toString()));

        int countOrders = 5;
        arrayOrders = new makeArrayOrders().createArrayOrders(countOrders);

        String name = "John";
        String secondName = "Smith";
        String patronymic = "Johnson";
        String phoneNumber = "+79123456789";
        int age = 52;
        String productName = "Футболка111111111";  //задаем неверный товар
        int productPrice = 20;
        int quantity = 10;
        Order order = makeOrder(name, secondName, patronymic, phoneNumber, age, productName, productPrice, quantity);
        if (order != null) {
            arrayOrders.add(order);
        }

        String name2 = "John";
        String secondName2 = "Smith";
        String patronymic2 = "Johnson";
        String phoneNumber2 = "+79123456789";
        int age2 = 52;
        String productName2 = "Футболка";
        int productPrice2 = 20;
        int quantity2 = 100;        //задаем неверное кол-во
        Order order2 = makeOrder(name2, secondName2, patronymic2, phoneNumber2,
                age2, productName2, productPrice2, quantity2);
        if (order2 != null) {
            arrayOrders.add(order2);
        }

        String name3 = "John";
        String secondName3 = "Smith";
        String patronymic3 = "Johnson";
        String phoneNumber3 = "+791234567890000000000";  //задаем неверного покупателя
        int age3 = 52;
        String productName3 = "Футболка";
        int productPrice3 = 20;
        int quantity3 = 10;
        Order order3 = makeOrder(name3, secondName3, patronymic3, phoneNumber3,
                age3, productName3, productPrice3, quantity3);
        if (order3 != null) {
            arrayOrders.add(order3);
        }

        arrayOrders.forEach(orders -> System.out.println(orders.toString()));

    }


    private static Order makeOrder(String name, String secondName, String patronymic, String phoneNumber, int age,
                                   String productName, int productPrice, int quantity) {
        int amount = quantity;

        Product product = new Product(productName, productPrice);
        boolean trueProduct = false;
        boolean trueAmount = false;
        // проверяем продукт
        try {
            trueProduct = checkProduct(product);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        // проверяем кол-во
        try {
            trueAmount = checkAmount(quantity);
        } catch (Exception e) {
            amount = 1;
            trueAmount = true;
            e.printStackTrace();
        }

        Buyer buy = new Buyer(name, secondName, patronymic, phoneNumber, age);
        boolean trueBuyer = false;
        try {
            trueBuyer = checkBuyer(buy);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (trueBuyer && trueProduct && trueAmount) {
            return new Order(buy, product, amount);
        }

        return null;
    }


    private static boolean checkBuyer(Buyer buy) {
        for (Buyer person : buyer) {
            if (person.equals(buy)) {
                return true;
            }
        }
        throw new CustomerException("Несуществующий покупатель");
    }


    private static boolean checkProduct(Product product) {
        for (Product prod : arrayProducts) {
            if (prod.equals(product)) {
                return true;
            }
        }
        throw new ProductException("Несуществующий товар");
    }


    private static boolean checkAmount(int amount) {
        for (Order order : arrayOrders) {
            if (order.getQuantity() == amount) {
                return true;
            }
        }
        throw new AmountException("Отрицательное или слишком больше значение количества");
    }

}
