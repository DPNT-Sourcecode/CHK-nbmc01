package befaster.solutions.CHK;

import java.util.HashMap;
import java.util.Map;

public class SpecialOffer implements Comparable<SpecialOffer> {
    private int offerPrice;
    private String itemsPurchased;
    private int saving;
    private Map<Character,Item> mapOfValidItems = new HashMap<>();

    public SpecialOffer(int offerPrice, String itemsPurchased, Map<Character, Item> mapOfValidItems) {
        this.offerPrice = offerPrice;
        this.itemsPurchased = itemsPurchased;
        this.mapOfValidItems = mapOfValidItems;
        int fullPriceTotal = 0;
        for(char thisSKU:itemsPurchased.toCharArray()){
            // get full price of thisSKU and add to fullPriceTotal
            // saving = fullPriceTotal - offerPrice
            // need to write Item separately first
        }
    }

    @Override
    public int compareTo(SpecialOffer o) {
        return 0;
    }
}

