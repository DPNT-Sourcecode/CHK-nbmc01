package befaster.solutions.CHK;

public class SpecialOffer {
    private int offerPrice;
    private String itemsPurchased;
    private int saving;
    private Map<Character,Item> mapOfValidItems;

    public SpecialOffer(int offerPrice, String itemsPurchased, Map<Character, Item> mapOfValidItems) {
        this.offerPrice = offerPrice;
        this.itemsPurchased = itemsPurchased;
        this.mapOfValidItems = mapOfValidItems;
        for(char itemSku:itemsPurchased){
            
        }
    }
}
