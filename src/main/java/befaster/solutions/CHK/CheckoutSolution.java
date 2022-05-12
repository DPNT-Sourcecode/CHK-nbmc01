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
        validItemMap.put('F',new Item('F',10));
        validItemMap.put('G',new Item('G',20));
        validItemMap.put('H',new Item('H',10));
        validItemMap.put('I',new Item('I',35));
        validItemMap.put('J',new Item('J',60));
        validItemMap.put('K',new Item('K',70));
        validItemMap.put('L',new Item('L',90));
        validItemMap.put('M',new Item('M',15));
        validItemMap.put('N',new Item('N',40));
        validItemMap.put('O',new Item('O',10));
        validItemMap.put('P',new Item('P',50));
        validItemMap.put('Q',new Item('Q',30));
        validItemMap.put('R',new Item('R',50));
        validItemMap.put('S',new Item('S',20));
        validItemMap.put('T',new Item('T',20));
        validItemMap.put('U',new Item('U',40));
        validItemMap.put('V',new Item('V',50));
        validItemMap.put('W',new Item('W',20));
        validItemMap.put('X',new Item('X',17));
        validItemMap.put('Y',new Item('Y',20));
        validItemMap.put('Z',new Item('Z',21));

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
        offersList.add(new SpecialOffer(20,"FFF",validItemMap));
        offersList.add(new SpecialOffer(45,"HHHHH",validItemMap));
        offersList.add(new SpecialOffer(80,"HHHHHHHHHH",validItemMap));
        offersList.add(new SpecialOffer(120,"KK",validItemMap));
        offersList.add(new SpecialOffer(3*40,"NNNM",validItemMap));
        offersList.add(new SpecialOffer(200,"PPPPP",validItemMap));
        offersList.add(new SpecialOffer(80,"QQQ",validItemMap));
        offersList.add(new SpecialOffer(3*50,"RRRQ",validItemMap));
        offersList.add(new SpecialOffer(3*40,"UUUU",validItemMap));
        offersList.add(new SpecialOffer(90,"VV",validItemMap));
        offersList.add(new SpecialOffer(130,"VVV",validItemMap));

        // add combo offers
        ComboOffers comboOffers = new ComboOffers();
        List<String> unchosenSkus = new ArrayList<>();
        // simulate an offer where can buy any three of items S, T, X, Y, Z for a fixed amount
        char[] involvedSkus = {'S', 'T', 'X', 'Y', 'Z'};
        int reqNoItems = 3;
        for (char thisSku : involvedSkus) {
            for (int itemID = 0; itemID < reqNoItems; itemID++) {
                // need as many of each sku as there are req number of items, to allow for repetition, eg someone buys "AAA"
                unchosenSkus.add(thisSku + "");
            }
        }
        comboOffers.makeCombinations(unchosenSkus, reqNoItems, "");
        Set<String> allPossibleCombos = comboOffers.getCombos();
        for(String combo:allPossibleCombos){
            offersList.add(new SpecialOffer(45,combo,validItemMap));
        }

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
