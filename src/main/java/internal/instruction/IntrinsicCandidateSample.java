package internal.instruction;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * JDK 내부 명령어
 * @IntrinsicCandidate
 *
 * - JVM 내부에서 최적화된 코드를 적용함
 * - JVM 내부 구현에 따라 달라질수 있음
 * - JVM 벤더사마다 다른 구현 방식을 가짐
 *
 * Native 인터페이스의 경우 C, C++로 작성된 코드와 링크되어 사용됨
 * 그것과 다르게 IntrinsicCandidate는 JVM 내부에서 최적화된 코드를 적용
 **/
public class IntrinsicCandidateSample {

    /**
     * System.arraycopy
     *
     *     @IntrinsicCandidate
     *     public static native void arraycopy(Object src,  int  srcPos,
     *                                         Object dest, int destPos,
     *                                         int length);
     */
    @Test
    void arrayCopyTest() {
        // given
        int[] src = {1, 2, 3, 4, 5};
        int[] dest = new int[5];

        // when
        System.arraycopy(src, 0, dest, 0, src.length);

        // then
        assertArrayEquals(src, dest);
    }
}
