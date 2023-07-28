package org.example;

import java.util.ArrayList;

public class MakeArrayBuyer {

    public ArrayList<Buyer> createArrayBuyer() {
        ArrayList<Buyer> buyer = new ArrayList<>();

        Buyer buy = new Buyer("John", "Smith", "Johnson", "+79123456789", 52);
        buyer.add(buy);
        Buyer buy2 = new Buyer("Emma", "Johnson", "Williamson", "+7915256789", 18);
        buyer.add(buy2);

        return buyer;
    }

}
