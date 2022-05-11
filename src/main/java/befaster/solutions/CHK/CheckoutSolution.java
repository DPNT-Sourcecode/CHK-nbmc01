package befaster.solutions.CHK;

import java.util.HashMap;
import java.util.Map;

public class CheckoutSolution {
    public Integer checkout(String skus) {
        skus = skus.toUpperCase();
        Map<Character,Item> mapOfValidItems = new HashMap<>();
        mapOfValidItems.put('A',new Item("A",50,3,130));
        mapOfValidItems.put('B',new Item("B",30,2,45));
        mapOfValidItems.put('C',new Item("C",20));
        mapOfValidItems.put('D',new Item("D",15));

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
                    remainingSkusToProcess.replace(String.thisSku,'');
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

        public Item(String name, int pricePerItem) {
            this.name = name;
            this.pricePerItem = pricePerItem;
            this.specialReqNum = -1;
            this.specialPrice = -1;
        }

        public Item(String name, int pricePerItem, int specialReqNum, int specialPrice) {
            this.name = name;
            this.pricePerItem = pricePerItem;
            this.specialReqNum = specialReqNum;
            this.specialPrice = specialPrice;
        }

        public int calcPrice(int noItems){
            if(this.specialReqNum==-1||noItems<this.specialReqNum){
                return noItems*pricePerItem;
            }else{
                int itemsAtFullPrice=noItems%this.specialReqNum;
                int noDiscountedLots=(noItems-itemsAtFullPrice)/this.specialReqNum;
                return itemsAtFullPrice*this.pricePerItem + noDiscountedLots*this.specialPrice;
            }
        }
    }
}



