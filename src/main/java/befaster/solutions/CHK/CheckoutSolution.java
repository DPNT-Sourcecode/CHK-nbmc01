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

        // check input valid
        for(char thisSku:skus.toCharArray()){
            if(!validItemMap.containsKey(thisSku)){
                return -1;
            }
        }

        List<SpecialOffer> offersList = new ArrayList<>();
        offersList.add(new SpecialOffer(130,"AAA",validItemMap));
        offersList.add(new SpecialOffer(200,"AAAAA",validItemMap));
        offersList.add(new SpecialOffer(45,"BB",validItemMap));
        offersList.add(new SpecialOffer(80,"EEB",validItemMap));
        Collections.sort(offersList,Collections.reverseOrder()); // use overridden compareTo method to sort so highest saving at top of list

        int totalPrice = 0;
        String remainingSkusToProcess = skus;

        // Apply offers in order of savings (biggest saving first)
        for(SpecialOffer nextBestOffer:offersList){
            while(!nextBestOffer.applyOfferToSku(remainingSkusToProcess).equals(remainingSkusToProcess)){
                // if offer can be applied, applyOfferToSku will return with counted skus set to lower case
                totalPrice+=nextBestOffer.getOfferPrice();
                remainingSkusToProcess = nextBestOffer.applyOfferToSku(remainingSkusToProcess);
            }
        }

        // Add up contributions from full price items
        char[] remainingSkusToProcessCharArr = remainingSkusToProcess.toCharArray();
        for(int i=0;i<remainingSkusToProcessCharArr.length;i++){
            char thisSku = remainingSkusToProcessCharArr[i];
            if(Character.isUpperCase(thisSku)){
                totalPrice+=validItemMap.get(thisSku).getFullPrice();
                remainingSkusToProcessCharArr[i] = Character.toLowerCase(thisSku);
            }
        }

        return totalPrice;
    }
}
