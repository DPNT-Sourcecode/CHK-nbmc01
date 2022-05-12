package befaster.solutions.CHK;

import java.util.ArrayList;
import java.util.List;

public class ComboOffers {

    private List<String> combos;

    public ComboOffers() {
        combos = new ArrayList<>();
    }

    public void makeCombinations(List<String> unchosenSkus, int reqNoItems, String accumulatedCombo) {
        // need to generate list of strings of all possible combinations of skus for new type of offers
        // can then add new SpecialOffers to offerList for each string

        if(unchosenSkus.size()<reqNoItems) {return;}

        if(reqNoItems==1){
            for(String sku:unchosenSkus){
                combos.add(accumulatedCombo+sku);
            }
        } else if(unchosenSkus.size()==reqNoItems){
            for(String sku:unchosenSkus){
                accumulatedCombo+=sku; // add all skus to accumulated string
            }
            combos.add(accumulatedCombo);
        } else{
            // else case when unchosenSkus.size()>reqNoItems
            for(int i=0;i<unchosenSkus.size();i++){
                makeCombinations(unchosenSkus.subList(i+1,unchosenSkus.size()),
                        reqNoItems-1,
                        accumulatedCombo+unchosenSkus.get(i));
            }
        }
    }

    public List<String> getCombos() {
        return combos;
    }
}
