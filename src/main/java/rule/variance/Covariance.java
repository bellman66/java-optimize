package rule.variance;

import java.util.List;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Covariance {

    private static class Parent {
        private String name;
    }

    private static class Child extends Parent {
        private String age;
    }

    @Test
    void covarianceTest() {
        // given
        Parent parent = new Parent();
        Child child = new Child();

        // when
        Parent result = child;

        // then
        assertEquals(child, result);
    }

    @Test
    void readCovarianceTest() {
        // given
        List<Child> childList = List.of(new Child(), new Child());

        // when
        List<? extends Parent> result = childList;

        // then
        assertEquals(childList, result);
    }
}
