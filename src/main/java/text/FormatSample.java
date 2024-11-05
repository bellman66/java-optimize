package text;

import org.junit.jupiter.api.Test;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;

import static org.junit.jupiter.api.Assertions.*;

public class FormatSample {

    @Test
    void DateFormat() {
        // given
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        // when
        String date = sdf.format(System.currentTimeMillis());

        // then
        assertNotNull(date);
    }

    @Test
    void NumberFormat() {
        // given
        NumberFormat format = NumberFormat.getInstance();

        // when
        String number = format.format(1234567890);

        // then
        assertEquals("1,234,567,890", number);
    }

}
