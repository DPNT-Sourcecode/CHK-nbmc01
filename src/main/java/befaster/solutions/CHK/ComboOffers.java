package befaster.solutions.CHK;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ComboOffers {

    private Set<String> combos;

    public ComboOffers() {
        combos = new HashSet<>();
    }

    public void makeCombinations(List<String> unchosenSkus, int reqNoItems, String accumulatedCombo) {
        // need to generate list of strings of all possible combinations of skus for new type of offers
        // can then add new SpecialOffers to offerList for each string

        // this function is a result of reading various stackOverFlow posts and I can't take credit for the algorithm
        // I've just adapted what I can find out there to my purposes. I found the following links particularly useful:
        // https://stackoverflow.com/questions/4240080/generating-all-permutations-of-a-given-string
        // https://en.wikipedia.org/wiki/Combination#Enumerating_k-combinations
        // https://hmkcode.com/calculate-find-all-possible-combinations-of-an-array-using-java/

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

    public Set<String> getCombos() {
        return combos;
    }
}


