package befaster.solutions.CHK;

import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ComboOffersTest extends TestCase {

    public void testMakeCombinations() {
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
        List<String> allPossibleCombos = comboOffers.getCombos();
        // there should be 9 combinations of 3 letters in 2 positions including repeats (eg AB and BA)
        assert (Objects.equals(allPossibleCombos.size(), 9));

    }
}