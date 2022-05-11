package befaster.solutions.CHK;

import junit.framework.TestCase;

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

    public void testCheckout_R2(){
        chk = new CheckoutSolution();
        assert(chk.checkout("EEEE").equals(80));
        assert(chk.checkout("EEE").equals(80));
        assert(chk.checkout("E").equals(40));
    }

}