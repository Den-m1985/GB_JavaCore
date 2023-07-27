package org.example;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        int countBuyer = 2;
        ArrayList<Buyer> buyer = new MakeArrayBuyer().createArrayBuyer(countBuyer);
        buyer.forEach(bur -> System.out.println(bur.toString()));

        int countGoods = 5;
        ArrayList<Goods> goods = new MakeArrayGoods().createArrayGoods(countGoods);
        goods.forEach(good -> System.out.println(good.toString()));
    }


}