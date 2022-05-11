package befaster.solutions.CHK;

import junit.framework.TestCase;
import org.junit.Before;

public class CheckoutSolutionTest extends TestCase {

    private CheckoutSolution chk;

    @Before
    public void setup(){
        chk = new CheckoutSolution();
    }

    public void testCheckout() {
        assertThat(chk.checkout("AAA"),equalTo(130));
    }
}