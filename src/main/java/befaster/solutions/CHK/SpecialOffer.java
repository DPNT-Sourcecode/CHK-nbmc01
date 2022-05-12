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

    public String applyOfferToSku(String skuToProcess){
        String processedSku = skuToProcess;
        for(char offerSkuChar:this.itemsPurchased.toCharArray()){
            int index = processedSku.indexOf(offerSkuChar);
            if(index!=-1){
                char[] remainingSkusCharArr = processedSku.toCharArray();
                // indexOf is case sensitive, wanted to mark presence of counted sku without deleting information (for debug)
                remainingSkusCharArr[index] = Character.toLowerCase(remainingSkusCharArr[index]);
                processedSku = String.valueOf(remainingSkusCharArr);
            }else{
                return skuToProcess; //needs remaining Skus must contain all offerSkuChar, if not, return orriginal sku
            }
        }
        return processedSku; // if made it through entire list of offerSkuChar then remainingSkus contains items for offer
    }

    public int getOfferPrice() {
        return offerPrice;
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


