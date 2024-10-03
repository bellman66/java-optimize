package contents.cache;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class IntegerCache {

    /**
     *  IntegerCache Test
     *
     *  Summary
     *  java에서 자주 쓰는 값을 캐싱해두는 로직에 대한 테스트
     *  -128 ~ 127 사이의 값은 캐싱
     *  그 외의 값은 캐싱하지 않음
     */
    @Test
    void cachePositiveInBoundaryEquals() {
        // given
        Integer first = 127;
        Integer second = 127;

        assertTrue(first == second);
    }

    @Test
    void cacheNegativeInBoundaryEquals() {
        // given
        Integer first = -127;
        Integer second = -127;

        assertTrue(first == second);
    }

    @Test
    void cachePositiveOutBoundaryEquals() {
        // given
        Integer first = 128;
        Integer second = 128;

        assertFalse(first == second);
    }

    @Test
    void cacheNegativeOutBoundaryEquals() {
        // given
        Integer first = -129;
        Integer second = -129;

        assertFalse(first == second);
    }
}
