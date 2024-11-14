package rule.variance;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

public class Invariance {

    @Test
    void invarianceTest() {
        // given
        List<? extends Number> list = new ArrayList<>();

        // when
        // Not add anything to the list
//        list.add(new Integer(1)); // compile error
//        list.add(new Long(1L));
    }
}
