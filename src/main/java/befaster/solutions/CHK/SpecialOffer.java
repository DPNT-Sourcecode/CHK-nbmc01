package befaster.solutions.CHK;

import java.util.Map;

public class SpecialOffer implements Comparable<SpecialOffer> {
    private int offerPrice;
    private String itemsPurchased;
    private int saving;
    private Map<Character,Item> mapOfValidItems;

    public SpecialOffer(int offerPrice, String itemsPurchased, Map<Character, Item> mapOfValidItems) {
        this.offerPrice = offerPrice;
        this.itemsPurchased = itemsPurchased;
        this.mapOfValidItems = mapOfValidItems;
        int fullPriceTotal = 0;
        for(char thisSku:itemsPurchased.toCharArray()){
            // get full price of thisSku and add to fullPriceTotal
            Item thisItem = mapOfValidItems.get(thisSku);
            fullPriceTotal += thisItem.getFullPrice();
        }
        this.saving = fullPriceTotal - this.offerPrice;
    }

    public int apply(String remainingSkus){
        if(remainingSkus.matches())
        return -1;
    }

    @Override
    public int compareTo(SpecialOffer o) {
        if(this.saving>o.saving){
            return 1;
        }else if(this.saving<o.saving){
            return -1;
        }else{
            return 0;
        }
    }
}

