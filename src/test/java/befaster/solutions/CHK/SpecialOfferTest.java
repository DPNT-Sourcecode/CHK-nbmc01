package befaster.solutions.CHK;

import junit.framework.TestCase;

import java.util.HashMap;
import java.util.Map;

public class SpecialOfferTest extends TestCase {

    public void testApply() {
        Map<Character,Item> validItemMap = new HashMap<>();
        validItemMap.put('A',new Item('A',50));
        validItemMap.put('B',new Item('B',30));
        validItemMap.put('C',new Item('C',20));
        validItemMap.put('D',new Item('D',15));
        validItemMap.put('E',new Item('E',40));

        SpecialOffer specialOffer = new SpecialOffer(130,"AAA",validItemMap);
        assert(((Integer)specialOffer.apply("AAAAA")).equals(130));
        assert(((Integer)specialOffer.apply("ABAA")).equals(130));
        assert(((Integer)specialOffer.apply("AA")).equals(-1));

    }
}