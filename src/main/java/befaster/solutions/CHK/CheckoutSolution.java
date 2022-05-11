package befaster.solutions.CHK;

import java.util.HashMap;
import java.util.Map;

public class CheckoutSolution {
    public Integer checkout(String skus) {
        // 2 server tests failed when passed in lower case inputs, I specifically allowed for this case
        // I will comment out the line below now and add another test
        // skus = skus.toUpperCase();
        Map<Character,Item> mapOfValidItems = new HashMap<>();
        mapOfValidItems.put('A',new Item("A",50,3,130));
        mapOfValidItems.put('B',new Item("B",30,2,45));
        mapOfValidItems.put('C',new Item("C",20));
        mapOfValidItems.put('D',new Item("D",15));
        mapOfValidItems.put('E',new Item("E",40,true,1,2));

        char[] skusCharArr = skus.toCharArray();
        int totalPrice = 0;
        String remainingSkusToProcess = skus;
        for(char thisSku:skusCharArr){
            if(!mapOfValidItems.containsKey(thisSku)){
                return -1;
            }else{
                int skuCount=0;
                // count number of items of this particular sku
                while(remainingSkusToProcess.indexOf(thisSku)!=-1){
                    skuCount++;
                    remainingSkusToProcess = remainingSkusToProcess.replaceFirst(Character.toString(thisSku),"");
                }
                // increment total price
                totalPrice+=mapOfValidItems.get(thisSku).calcPrice(skuCount);
            }
        }
        return totalPrice;
    }

    class Item{
        private String name;
        private int pricePerItem;
        private int specialReqNum;
        private int specialPrice;
        private boolean bogOff;
        private int bogOffBuy; // maybe confusingly named, how many items you have to pay for in a bogOff offer
        private int bogOffGet; // how many items you get per bogOff offer

        public Item(String name, int pricePerItem) {
            this.name = name;
            this.pricePerItem = pricePerItem;
            this.specialReqNum = -1;
            this.specialPrice = -1;
            this.bogOff = false;
            this.bogOffBuy = -1;
            this.bogOffGet = -1;
        }

        public Item(String name, int pricePerItem, int specialReqNum, int specialPrice) {
            this.name = name;
            this.pricePerItem = pricePerItem;
            this.specialReqNum = specialReqNum;
            this.specialPrice = specialPrice;
            this.bogOff = false;
            this.bogOffBuy = -1;
            this.bogOffGet = -1;
        }

        public Item(String name, int pricePerItem, boolean bogOff, int bogOffBuy, int bogOffGet) {
            // here I've added another constructor to save breaking existing code (excuse over commenting :) )
            this.name = name;
            this.pricePerItem = pricePerItem;
            this.bogOff = bogOff;
            this.bogOffBuy = bogOffBuy;
            this.bogOffGet = bogOffGet;
        }

        public int calcPrice(int noItems){
            if(this.specialReqNum==-1||noItems<this.specialReqNum){
                return noItems*pricePerItem;
            }else if (bogOff){
                int itemsAtFullPrice=noItems%this.bogOffGet;
                int bogOffLots = (noItems-itemsAtFullPrice)/bogOffGet;
                return bogOffLots*this.bogOffBuy*this.pricePerItem;
            }else{
                int itemsAtFullPrice=noItems%this.specialReqNum;
                int noDiscountedLots=(noItems-itemsAtFullPrice)/this.specialReqNum;
                return itemsAtFullPrice*this.pricePerItem + noDiscountedLots*this.specialPrice;
            }
        }
    }
}
