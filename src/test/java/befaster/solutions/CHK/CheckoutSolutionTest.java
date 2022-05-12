package befaster.solutions.CHK;

import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.Objects;

public class CheckoutSolutionTest extends TestCase {

    private CheckoutSolution chk;

    public void testCheckout_R1() {
        chk = new CheckoutSolution();
        assert(Objects.equals(chk.checkout("AAA"),130));
        assert(Objects.equals(chk.checkout("B"),30));
        assert(Objects.equals(chk.checkout("BBB"),(45+30)));
        assert(Objects.equals(chk.checkout("AACC"),(2*50+2*20)));
    }

    public void testCheckout_invalidInputs(){
        chk = new CheckoutSolution();
        assert(Objects.equals(chk.checkout("+CC"),-1));
        assert(Objects.equals(chk.checkout("aCC"),-1));
    }

    public void testCheckout_bogOff(){
        chk = new CheckoutSolution();
        assert(Objects.equals(chk.checkout("EEB"),80));
        assert(Objects.equals(chk.checkout("BEE"),80));
    }

    public void testCheckout_chooseCorrectOffer(){
        chk = new CheckoutSolution();
        assert(Objects.equals(chk.checkout("AAAAA"),200));
        assert(Objects.equals(chk.checkout("AAAAAA"),250));
    }

    public void testCheckout_largeMixedUpOrder(){
        chk = new CheckoutSolution();
        //5As, 5Bs and 6Es should be 3 free Bs, 2Bs for 45, 5As for 200 and 6Es at 40 each
        int expectedCost = 200+45+6*40;
        assert(Objects.equals(chk.checkout("EEABAEABBBEBEAAE"),expectedCost));
    }

    public void testCheckout_bogOffF(){
        chk = new CheckoutSolution();
        assert(Objects.equals(chk.checkout("FFF"),20));
    }

    public void testCheckout_megaBuy(){
        chk = new CheckoutSolution();
        //5Hs, 2Ks, 10Ps, 11Rs, 3Qs, J and Z
        int expectedCost = 45+150+200*2+11*50+60+50;
        assert(Objects.equals(chk.checkout("RRRHPPRRRRRJQQRRQRPHPZPKHKHPPPPPH"),expectedCost));
    }

    public void testMakeCombinations() {
        chk = new CheckoutSolution();
        ArrayList<String> unchosenSkus = new ArrayList<>();
        // simulate an offer where can buy any two of items A, B or C for a fixed amount
        char[] involvedSkus = {'A','B','C'};
        int reqNoItems = 2;
        for(char thisSku:involvedSkus){
            for(int itemID=0;itemID<reqNoItems;itemID++){
                // need as many of each sku as there are req number of items, to allow for repetition, eg someone buys "AAA"
                unchosenSkus.add(thisSku+"");
            }
        }
        ArrayList<String> allPossibleCombos = chk.makeCombinations(unchosenSkus,reqNoItems,"");
        // there should be 9 combinations of 3 letters in 2 positions including repeats (eg AB and BA)
        assert(Objects.equals(allPossibleCombos.size(),9));
    }
}