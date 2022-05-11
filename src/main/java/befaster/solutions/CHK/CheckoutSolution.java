package befaster.solutions.CHK;

import java.util.ArrayList;
import java.util.List;

public class CheckoutSolution {
    public Integer checkout(String skus) {
        List<Item> listOfValidItems = new ArrayList<>();
        listOfValidItems.add(new Item("A",50,3,130));
        listOfValidItems.add(new Item("B",30,2,45));
        listOfValidItems.add(new Item("C",20));
        listOfValidItems.add(new Item("D",15));

        
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
