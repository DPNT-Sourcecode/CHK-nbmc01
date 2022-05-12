package befaster.solutions.CHK;

import java.util.*;

public class CheckoutSolution {
    public Integer checkout(String skus) {

        Map<Character,Item> validItemMap = new HashMap<>();
        validItemMap.put('A',new Item('A',50));
        validItemMap.put('B',new Item('B',30));
        validItemMap.put('C',new Item('C',20));
        validItemMap.put('D',new Item('D',15));
        validItemMap.put('E',new Item('E',40));

        List<SpecialOffer> offersList = new ArrayList<>();
        offersList.add(new SpecialOffer(130,"AAA",validItemMap));
        offersList.add(new SpecialOffer(200,"AAAAA",validItemMap));
        offersList.add(new SpecialOffer(45,"BB",validItemMap));
        offersList.add(new SpecialOffer(40,"EEB",validItemMap));
        Collections.sort(offersList); // use overridden compareTo method to sort so highest saving at top of list

//        char[] skusCharArr = skus.toCharArray();
        int totalPrice = 0;
        String remainingSkusToProcess = skus;

        // need a new method that returns price if successful, -1 if not:  int SpecialOffer.apply(String remainingSkusToProcess)
        // then can chew through, remainingSkusToProcess prioritising biggest saving
        // think this is 'Greedy' approach? Think ok because question says 'offers can be safely combined'
        // I've read this to mean, 'local best solution will provide global best'
        // Appears to be true for current price table anyway. ie always cheaper to take free B if available than use 2 for 45 deal
        // excuse over commenting, thinking outloud. Will delete soon!



//        for(char thisSku:skusCharArr){
//            if(!validItemMap.containsKey(thisSku)){
//                return -1;
//            }else{
//                int skuCount=0;
//                // count number of items of this particular sku
//                while(remainingSkusToProcess.indexOf(thisSku)!=-1){
//                    skuCount++;
//                    remainingSkusToProcess = remainingSkusToProcess.replaceFirst(Character.toString(thisSku),"");
//                }
//                // check for bogOffs
//                Item bogOffItem = validItemMap.get(thisSku).getBogOffItem();
//                if(bogOffItem!=null){
//                    int bogOffBuy = validItemMap.get(thisSku).getBogOffBuy();
//                    int bogOffLots = skuCount/bogOffBuy;
//                    int noFreeItems = bogOffLots*validItemMap.get(thisSku).getBogOffGet();
//                    for(int freeItemID=1;freeItemID<=noFreeItems;freeItemID++){
//                        remainingSkusToProcess = remainingSkusToProcess.replaceFirst(bogOffItem.getName(),"");
//                    }
//                }
//                // increment total price
//                totalPrice+=validItemMap.get(thisSku).calcPrice(skuCount);
//            }
//        }
        return totalPrice;
    }

//    class Item{
//        private String name;
//        private int pricePerItem;
//        private int specialReqNum;
//        private int specialPrice;
//        private Item bogOffItem;
//        private int bogOffBuy; // maybe confusingly named, how many items you have to pay for in a bogOff offer
//        private int bogOffGet; // how many items you get per bogOff offer
//
//        public Item(String name, int pricePerItem) {
//            this.name = name;
//            this.pricePerItem = pricePerItem;
//            this.specialReqNum = -1;
//            this.specialPrice = -1;
//            this.bogOffItem = null;
//            this.bogOffBuy = -1;
//            this.bogOffGet = -1;
//        }
//
//        public Item(String name, int pricePerItem, int specialReqNum, int specialPrice) {
//            this.name = name;
//            this.pricePerItem = pricePerItem;
//            this.specialReqNum = specialReqNum;
//            this.specialPrice = specialPrice;
//            this.bogOffItem = null;
//            this.bogOffBuy = -1;
//            this.bogOffGet = -1;
//        }
//
//        public Item(String name, int pricePerItem, Item bogOffItem, int bogOffBuy, int bogOffGet) {
//            this.name = name;
//            this.pricePerItem = pricePerItem;
//            this.bogOffItem = bogOffItem;
//            this.bogOffBuy = bogOffBuy;
//            this.bogOffGet = bogOffGet;
//        }
//
//        public int calcPrice(int noItems){
//            if(this.specialReqNum==-1||noItems<this.specialReqNum){
//                return noItems*pricePerItem;
//            }else if (bogOffItem!=null){
////                int itemsAtFullPrice=noItems%this.bogOffGet;
////                int bogOffLots = (noItems-itemsAtFullPrice)/bogOffGet;
////                return (bogOffLots*this.bogOffBuy+itemsAtFullPrice)*this.pricePerItem;
//                return noItems*pricePerItem;
//            }else{
//                int itemsAtFullPrice=noItems%this.specialReqNum;
//                int noDiscountedLots=(noItems-itemsAtFullPrice)/this.specialReqNum;
//                return itemsAtFullPrice*this.pricePerItem + noDiscountedLots*this.specialPrice;
//            }
//        }
//
//        public Item getBogOffItem() {
//            return bogOffItem;
//        }
//
//        public int getBogOffGet() {
//            return bogOffGet;
//        }
//
//        public int getBogOffBuy() {
//            return bogOffBuy;
//        }
//
//        public String getName() {
//            return name;
//        }
//    }
}
