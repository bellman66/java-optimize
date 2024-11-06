package text;

import org.junit.jupiter.api.Test;

import java.text.ChoiceFormat;
import java.text.MessageFormat;
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

    @Test
    void ChoiceFormat() {
        // given
        double[] limits = {60, 70, 80, 90};
        String[] grades = {"D", "C", "B", "A"};
        ChoiceFormat format = new ChoiceFormat(limits, grades);

        // when
        String grade1 = format.format(85);
        String grade2 = format.format(95);

        // then
        assertEquals("B", grade1);
        assertEquals("A", grade2);
    }

    @Test
    void MessageFormat() {
        // given
        String template = "Hello World, {0}! You have {1} new messages.";

        // when
        String formattedMessage = MessageFormat.format(template, "Youn", 5);

        // then
        assertEquals("Hello World, Youn! You have 5 new messages.", formattedMessage);
    }
}
