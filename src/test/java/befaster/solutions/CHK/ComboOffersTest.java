package befaster.solutions.CHK;

import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class ComboOffersTest extends TestCase {

    public void testMakeCombinations_simplifiedCase() {
        ComboOffers comboOffers = new ComboOffers();

        List<String> unchosenSkus = new ArrayList<>();
        // simulate an offer where can buy any two of items A, B or C for a fixed amount
        char[] involvedSkus = {'A', 'B', 'C'};
        int reqNoItems = 2;
        for (char thisSku : involvedSkus) {
            for (int itemID = 0; itemID < reqNoItems; itemID++) {
                // need as many of each sku as there are req number of items, to allow for repetition, eg someone buys "AAA"
                unchosenSkus.add(thisSku + "");
            }
        }

        comboOffers.makeCombinations(unchosenSkus, reqNoItems, "");
        Set<String> allPossibleCombos = comboOffers.getCombos();
        // there should be 6 combinations of 3 letters in 2 positions without repeats (eg AB and BA)
        assert (Objects.equals(allPossibleCombos.size(), 6));

    }

    public void testMakeCombinations_actualCase() {
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
        // 'I think!' there should be 35 combinations of 5 letters in 3 positions without repeats (ie treat AB and BA as the same)
        assert (Objects.equals(allPossibleCombos.size(), 35));

    }
}