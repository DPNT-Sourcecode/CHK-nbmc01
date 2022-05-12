package befaster.solutions.CHK;

import junit.framework.TestCase;

import java.util.Objects;

public class CheckoutSolutionTest extends TestCase {

    private CheckoutSolution chk;

    public void testCheckout_R1() {
        chk = new CheckoutSolution();
        assert(chk.checkout("AAA").equals(130));
        assert(chk.checkout("B").equals(30));
        assert(chk.checkout("BBB").equals(45+30));
        assert(chk.checkout("AACC").equals(2*50+2*20));
        assert(chk.checkout("+CC").equals(-1));
        assert(chk.checkout("aCC").equals(-1));
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

}