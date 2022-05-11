package befaster.solutions.CHK;

import java.util.HashMap;
import java.util.Map;

public class CheckoutSolution {
    public Integer checkout(String skus) {
        // 2 server tests failed when passed in lower case inputs, I specifically allowed for this case
        // I will comment out the line below now and add another test
        // skus = skus.toUpperCase();
        Map<Character,Item> mapOfValidItems = new HashMap<>();
        Item B = new Item("B",30,2,45);
        mapOfValidItems.put('A',new Item("A",50,3,130));
        mapOfValidItems.put('B',B);
        mapOfValidItems.put('C',new Item("C",20));
        mapOfValidItems.put('D',new Item("D",15));
        mapOfValidItems.put('E',new Item("E",40,B,1,2));

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
                // check for bogOffs
                Item bogOffItem = mapOfValidItems.get(thisSku).getBogOffItem();
                if(bogOffItem!=null){
                    int bogOffBuy = mapOfValidItems.get(thisSku).getBogOffBuy();
                    int bogOffLots = skuCount/bogOffBuy;
                    int noFreeItems = bogOffLots*mapOfValidItems.get(thisSku).getBogOffGet();
                    for(int freeItemID=1;freeItemID<=noFreeItems;freeItemID++){
                        remainingSkusToProcess = remainingSkusToProcess.replaceFirst(bogOffItem.getName(),"");
                    }
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
        private Item bogOffItem;
        private int bogOffBuy; // maybe confusingly named, how many items you have to pay for in a bogOff offer
        private int bogOffGet; // how many items you get per bogOff offer

        public Item(String name, int pricePerItem) {
            this.name = name;
            this.pricePerItem = pricePerItem;
            this.specialReqNum = -1;
            this.specialPrice = -1;
            this.bogOffItem = null;
            this.bogOffBuy = -1;
            this.bogOffGet = -1;
        }

        public Item(String name, int pricePerItem, int specialReqNum, int specialPrice) {
            this.name = name;
            this.pricePerItem = pricePerItem;
            this.specialReqNum = specialReqNum;
            this.specialPrice = specialPrice;
            this.bogOffItem = null;
            this.bogOffBuy = -1;
            this.bogOffGet = -1;
        }

        public Item(String name, int pricePerItem, Item bogOffItem, int bogOffBuy, int bogOffGet) {
            this.name = name;
            this.pricePerItem = pricePerItem;
            this.bogOffItem = bogOffItem;
            this.bogOffBuy = bogOffBuy;
            this.bogOffGet = bogOffGet;
        }

        public int calcPrice(int noItems){
            if(this.specialReqNum==-1||noItems<this.specialReqNum){
                return noItems*pricePerItem;
            }else if (bogOffItem!=null){
//                int itemsAtFullPrice=noItems%this.bogOffGet;
//                int bogOffLots = (noItems-itemsAtFullPrice)/bogOffGet;
//                return (bogOffLots*this.bogOffBuy+itemsAtFullPrice)*this.pricePerItem;
                return noItems*pricePerItem;
            }else{
                int itemsAtFullPrice=noItems%this.specialReqNum;
                int noDiscountedLots=(noItems-itemsAtFullPrice)/this.specialReqNum;
                return itemsAtFullPrice*this.pricePerItem + noDiscountedLots*this.specialPrice;
            }
        }

        public Item getBogOffItem() {
            return bogOffItem;
        }

        public int getBogOffGet() {
            return bogOffGet;
        }

        public int getBogOffBuy() {
            return bogOffBuy;
        }

        public String getName() {
            return name;
        }
    }
}
