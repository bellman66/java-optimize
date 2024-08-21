package origin.jsr41_assertion_facility;

import org.junit.jupiter.api.Test;

public class example {

    // enable java -ea (-enableassertions) Option
    @Test
    void asseertSample() {
        // given
        String input = "hello world";

        assert input != null;
        assert input.isBlank(); // throw java.lang.AssertionError
    }
}
