package junit;

/**
 * Sample call
 *
 * C:\Users\rndso\.jdks\graalvm-jdk-21.0.3\bin\java.exe -ea \
 *   -Didea.test.cyclic.buffer.size=1048576 \
 *   "-javaagent:C:\Program Files\JetBrains\IntelliJ IDEA 2024.3\lib\idea_rt.jar=65060:C:\Program Files\JetBrains\IntelliJ IDEA 2024.3\bin" \
 *   -javaagent:C:\Users\rndso\AppData\Local\JetBrains\IntelliJIdea2024.3\captureAgent\debugger-agent.jar \
 *   -Dkotlinx.coroutines.debug.enable.creation.stack.trace=false \
 *   -Ddebugger.agent.enable.coroutines=true \
 *   -Dkotlinx.coroutines.debug.enable.flows.stack.trace=true \
 *   -Dkotlinx.coroutines.debug.enable.mutable.state.flows.stack.trace=true \
 *   -Dfile.encoding=UTF-8 \
 *   -Dsun.stdout.encoding=UTF-8 \
 *   -Dsun.stderr.encoding=UTF-8 \
 *   -classpath "
 *       C:\Users\rndso\.m2\repository\org\junit\platform\junit-platform-launcher\1.8.1\junit-platform-launcher-1.8.1.jar;
 *       C:\Users\rndso\.m2\repository\org\junit\platform\junit-platform-engine\1.8.1\junit-platform-engine-1.8.1.jar;
 *       C:\Users\rndso\.m2\repository\org\opentest4j\opentest4j\1.2.0\opentest4j-1.2.0.jar;
 *       C:\Users\rndso\.m2\repository\org\junit\platform\junit-platform-commons\1.8.1\junit-platform-commons-1.8.1.jar;
 *       C:\Users\rndso\.m2\repository\org\apiguardian\apiguardian-api\1.1.2\apiguardian-api-1.1.2.jar;
 *       C:\Program Files\JetBrains\IntelliJ IDEA 2024.3\lib\idea_rt.jar;
 *       C:\Program Files\JetBrains\IntelliJ IDEA 2024.3\plugins\junit\lib\junit5-rt.jar;
 *       C:\Program Files\JetBrains\IntelliJ IDEA 2024.3\plugins\junit\lib\junit-rt.jar;
 *       C:\workspace\java-optimize\build\classes\java\main;
 *       C:\workspace\java-optimize\build\resources\main;
 *       C:\Users\rndso\.gradle\caches\modules-2\files-2.1\org.junit.jupiter\junit-jupiter-api\5.8.1\junit-jupiter-api-5.8.1.jar;
 *       C:\Users\rndso\.gradle\caches\modules-2\files-2.1\org.openjdk.jmh\jmh-generator-annprocess\1.36\jmh-generator-annprocess-1.36.jar;
 *       C:\Users\rndso\.gradle\caches\modules-2\files-2.1\org.openjdk.jmh\jmh-core\1.36\jmh-core-1.36.jar;
 *       C:\Users\rndso\.gradle\caches\modules-2\files-2.1\org.springframework\spring-context\6.1.11\spring-context-6.1.11.jar;
 *       C:\Users\rndso\.gradle\caches\modules-2\files-2.1\com.h2database\h2\1.4.200\h2-1.4.200.jar;
 *       C:\Users\rndso\.gradle\caches\modules-2\files-2.1\cglib\cglib\3.3.0\cglib-3.3.0.jar;
 *       C:\Users\rndso\.gradle\caches\modules-2\files-2.1\io.projectreactor\reactor-core\3.7.0\reactor-core-3.7.0.jar;
 *       C:\Users\rndso\.gradle\caches\modules-2\files-2.1\org.junit.platform\junit-platform-commons\1.8.1\junit-platform-commons-1.8.1.jar;
 *       C:\Users\rndso\.gradle\caches\modules-2\files-2.1\org.opentest4j\opentest4j\1.2.0\opentest4j-1.2.0.jar;
 *       C:\Users\rndso\.gradle\caches\modules-2\files-2.1\org.apiguardian\apiguardian-api\1.1.2\apiguardian-api-1.1.2.jar;
 *       C:\Users\rndso\.gradle\caches\modules-2\files-2.1\net.sf.jopt-simple\jopt-simple\5.0.4\jopt-simple-5.0.4.jar;
 *       C:\Users\rndso\.gradle\caches\modules-2\files-2.1\org.apache.commons\commons-math3\3.2\commons-math3-3.2.jar;
 *       C:\Users\rndso\.gradle\caches\modules-2\files-2.1\org.springframework\spring-aop\6.1.11\spring-aop-6.1.11.jar;
 *       C:\Users\rndso\.gradle\caches\modules-2\files-2.1\org.springframework\spring-beans\6.1.11\spring-beans-6.1.11.jar;
 *       C:\Users\rndso\.gradle\caches\modules-2\files-2.1\org.springframework\spring-expression\6.1.11\spring-expression-6.1.11.jar;
 *       C:\Users\rndso\.gradle\caches\modules-2\files-2.1\org.springframework\spring-core\6.1.11\spring-core-6.1.11.jar;
 *       C:\Users\rndso\.gradle\caches\modules-2\files-2.1\io.micrometer\micrometer-observation\1.12.8\micrometer-observation-1.12.8.jar;
 *       C:\Users\rndso\.gradle\caches\modules-2\files-2.1\org.ow2.asm\asm\7.1\asm-7.1.jar;
 *       C:\Users\rndso\.gradle\caches\modules-2\files-2.1\org.reactivestreams\reactive-streams\1.0.4\reactive-streams-1.0.4.jar;
 *       C:\Users\rndso\.gradle\caches\modules-2\files-2.1\org.springframework\spring-jcl\6.1.11\spring-jcl-6.1.11.jar;
 *       C:\Users\rndso\.gradle\caches\modules-2\files-2.1\io.micrometer\micrometer-commons\1.12.8\micrometer-commons-1.12.8.jar;
 *       C:\Users\rndso\.gradle\caches\modules-2\files-2.1\org.junit.jupiter\junit-jupiter-engine\5.8.1\junit-jupiter-engine-5.8.1.jar;
 *       C:\Users\rndso\.gradle\caches\modules-2\files-2.1\org.junit.platform\junit-platform-engine\1.8.1\junit-platform-engine-1.8.1.jar;
 *   " \
 *   com.intellij.rt.junit.JUnitStarter -ideVersion5 -junit5 \
 *   util.concurrent.atomic.AtomicSample,atomicBooleanSample
 */
public final class JUnitStarter {
    public static final int VERSION = 5;
    public static final java.lang.String IDE_VERSION = "-ideVersion";
    public static final java.lang.String JUNIT3_PARAMETER = "-junit3";
    public static final java.lang.String JUNIT4_PARAMETER = "-junit4";
    public static final java.lang.String JUNIT5_PARAMETER = "-junit5";
    private static final java.lang.String JUNIT5_KEY = "idea.is.junit5";
    private static final java.lang.String SOCKET = "-socket";
    private static final java.lang.String JUNIT3_RUNNER_NAME = "com.intellij.junit3.JUnit3IdeaTestRunner";
    private static final java.lang.String JUNIT4_RUNNER_NAME = "com.intellij.junit4.JUnit4IdeaTestRunner";
    private static final java.lang.String JUNIT5_RUNNER_NAME = "com.intellij.junit5.JUnit5IdeaTestRunner";
    private static java.lang.String ourForkMode;
    private static java.lang.String ourCommandFileName;
    private static java.lang.String ourWorkingDirs;
    static int ourCount;
    public static java.lang.String ourRepeatCount;

    public JUnitStarter() { /* compiled code */ }

    public static void main(java.lang.String[] args) { /* compiled code */ }

    private static java.lang.String processParameters(java.util.List<java.lang.String> args, java.util.List<? super java.lang.String> listeners, java.lang.String[] params) { /* compiled code */ }

    private static boolean isJUnit5Preferred() { /* compiled code */ }

    public static boolean checkVersion(java.lang.String[] args, java.io.PrintStream printStream) { /* compiled code */ }

    private static boolean canWorkWithJUnitVersion(java.io.PrintStream printStream, java.lang.String agentName) { /* compiled code */ }

    private static void junitVersionChecks(java.lang.String agentName) throws java.lang.ClassNotFoundException { /* compiled code */ }

    private static int prepareStreamsAndStart(java.lang.String[] args, java.lang.String agentName, java.util.ArrayList<java.lang.String> listeners, java.lang.String name) { /* compiled code */ }

    static java.lang.Class<?> getAgentClass(java.lang.String agentName) throws java.lang.ClassNotFoundException { /* compiled code */ }

    public static void printClassesList(java.util.List<java.lang.String> classNames, java.lang.String packageName, java.lang.String category, java.lang.String filters, java.io.File tempFile) throws java.io.IOException { /* compiled code */ }
}
