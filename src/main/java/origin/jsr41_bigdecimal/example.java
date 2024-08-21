package origin.jsr41_bigdecimal;

import java.math.BigDecimal;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class example {

    @DisplayName("BigDecimal 더하기")
    @Test
    void sum() {
        BigDecimal first = new BigDecimal("0.1");
        BigDecimal second = new BigDecimal("0.1");

        BigDecimal result = first.add(second);

        assertEquals(new BigDecimal("0.2"), result);
    }

    @DisplayName("BigDecimal 빼기")
    @Test
    void subtract() {
        BigDecimal first = new BigDecimal("0.36");
        BigDecimal second = new BigDecimal("0.7");

        BigDecimal result = first.subtract(second);

        assertEquals(new BigDecimal("-0.34"), result);
    }

    @DisplayName("BigDecimal 속성")
    @Test
    void properties() {
        BigDecimal bd = new BigDecimal("-12345.6789");

        assertEquals(9, bd.precision());
        assertEquals(4, bd.scale());
        assertEquals(-1, bd.signum());
    }
}
