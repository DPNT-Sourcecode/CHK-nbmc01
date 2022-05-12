package befaster.solutions.CHK;

import junit.framework.TestCase;

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

}

