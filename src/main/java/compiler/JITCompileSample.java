package compiler;

import org.junit.jupiter.api.Test;

public class JITCompileSample {

    /**
     * add -XX:CompileThreshold=100 -XX:OnStackReplacePercentage=33
     *
     * CompileThreshold
     * 컴파일 전에 해석된 메서드 호출 수를 설정합니다.
     * 기본적으로 서버 JVM에서 JIT 컴파일러는 효율적인 컴파일을 위한 정보를 수집하기 위해 10,000개의 해석된 메서드 호출을 수행합니다.
     * 클라이언트 JVM의 경우 기본 설정은 1,500개의 호출입니다.
     * 계층 컴파일이 활성화된 경우 이 옵션은 무시됩니다. 옵션을 참조하세요 -XX:+TieredCompilation.
     * 다음 예에서는 해석된 메서드 호출 수를 5,000으로 설정.
     *  -XX:컴파일 임계값=5000
     * 옵션을 지정하여 컴파일 전에 Java 메서드 해석을 완전히 비활성화할 수 있습니다 -Xcomp.
     *
     * @see https://docs.oracle.com/javase/8/docs/technotes/tools/unix/java.html
     */
    @Test
    void compileLoop() {
        // given
        int testCount = 500;
        int loopCount = 1000;

        // when
        for (int i=0; i<testCount; i++) {
            long start = System.nanoTime();

            total(loopCount);

            System.out.println(i + " = " + (System.nanoTime() - start));
        }
    }

    private int sum(int a, int b) {
        return a + b;
    }

    private void total(int count) {
        for (int i=0; i<count; i++) {
            sum(count, i);
        }
    }
}
