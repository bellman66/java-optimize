package time;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class LocalTimeSample {

    @Test
    void LocalDateTimeTest() {
        // given
        LocalDate date = LocalDate.of(2021, 1, 1);
        LocalTime time = LocalTime.of(12, 0, 0);

        // when & then
        assertEquals(date.toString(), "2021-01-01");
        assertEquals(time.toString(), "12:00");
    }

    @Test
    void ZonedDateTimeTest() {
        // given
        ZonedDateTime zonedDateTime = ZonedDateTime.of(2021, 1, 1, 12, 0, 0, 0, ZoneId.of("Asia/Seoul"));

        // when & then
        assertEquals(zonedDateTime.toString(), "2021-01-01T12:00+09:00[Asia/Seoul]");
    }

    @Test
    void instantTest() {
        // given
        Instant timestamp = Instant.now();

        // when & then
        System.out.println("timestamp = " + timestamp);
        assertNotNull(timestamp);
    }
}
