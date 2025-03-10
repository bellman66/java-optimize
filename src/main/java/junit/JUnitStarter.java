package junit;

//import com.intellij.rt.execution.junit.RepeatCount;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Sample call
 * option -junit5 link to JUnit5IdeaTestRunner
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
// Copyright 2000-2021 JetBrains s.r.o. and contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
public final class JUnitStarter {
    public static final int VERSION = 5;
    public static final String IDE_VERSION = "-ideVersion";

    public static final String JUNIT3_PARAMETER = "-junit3";
    public static final String JUNIT4_PARAMETER = "-junit4";
    public static final String JUNIT5_PARAMETER = "-junit5";
    private static final String JUNIT5_KEY = "idea.is.junit5";

    private static final String SOCKET = "-socket";
    private static final String JUNIT3_RUNNER_NAME = "com.intellij.junit3.JUnit3IdeaTestRunner";
    private static final String JUNIT4_RUNNER_NAME = "com.intellij.junit4.JUnit4IdeaTestRunner";
    private static final String JUNIT5_RUNNER_NAME = "com.intellij.junit5.JUnit5IdeaTestRunner";
    private static String ourForkMode;
    private static String ourCommandFileName;
    private static String ourWorkingDirs;
    static int ourCount = 1;
    public static String ourRepeatCount;

    public static void main(String[] args) {
        List<String> argList = new ArrayList<>(Arrays.asList(args));

        final ArrayList<String> listeners = new ArrayList<>();
        final String[] name = new String[1];

        String agentName = processParameters(argList, listeners, name);

        if (!JUNIT5_RUNNER_NAME.equals(agentName) && !canWorkWithJUnitVersion(System.err, agentName)) {
            System.exit(-3);
        }
        if (!checkVersion(args, System.err)) {
            System.exit(-3);
        }

        String[] array = argList.toArray(new String[0]);
        int exitCode = prepareStreamsAndStart(array, agentName, listeners, name[0]);
        System.exit(exitCode);
    }

    private static String processParameters(List<String> args, final List<? super String> listeners, String[] params) {
        String agentName = isJUnit5Preferred() ? JUNIT5_RUNNER_NAME : JUNIT4_RUNNER_NAME;
        List<String> result = new ArrayList<>(args.size());

        for (String arg : args) {
            if (arg.startsWith(IDE_VERSION)) {
                //ignore
            }
            else if (arg.equals(JUNIT3_PARAMETER)) {
                agentName = JUNIT3_RUNNER_NAME;
            }
            else if (arg.equals(JUNIT4_PARAMETER)) {
                agentName = JUNIT4_RUNNER_NAME;
            }
            else if (arg.equals(JUNIT5_PARAMETER)) {
                agentName = JUNIT5_RUNNER_NAME;
            }
            else {
                if (arg.startsWith("@name")) {
                    params[0] = arg.substring("@name".length());
                    continue;
                }
                else if (arg.startsWith("@w@")) {
                    ourWorkingDirs = arg.substring(3);
                    continue;
                }
                else if (arg.startsWith("@@@")) {
                    final int pos = arg.indexOf(',');
                    ourForkMode = arg.substring(3, pos);
                    ourCommandFileName = arg.substring(pos + 1);
                    continue;
                }
                else if (arg.startsWith("@@")) {
                    if (new File(arg.substring(2)).exists()) {
                        try {
                            final BufferedReader reader = new BufferedReader(new FileReader(arg.substring(2)));
                            String line;
                            while ((line = reader.readLine()) != null) {
                                listeners.add(line);
                            }
                        }
                        catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    continue;
                }
                else if (arg.startsWith(SOCKET)) {
                    // the form of "-socket[<host>:]<port>" is expected here
                    // for example "-sockethost.docker.internal:12345" or "-socket54321"
                    final String value = arg.substring(SOCKET.length());
                    final String host;
                    final int port;
                    // NB the host might be an IPv6 address (and this kind of address contains ":")
                    int index = value.lastIndexOf(':');
                    if (index == -1) {
                        host = "127.0.0.1";
                        port = Integer.parseInt(value);
                    }
                    else {
                        host = value.substring(0, index);
                        port = Integer.parseInt(value.substring(index + 1));
                    }
                    try {
                        final Socket socket = new Socket(InetAddress.getByName(host), port);  //start collecting tests
                        try (DataInputStream os = new DataInputStream(socket.getInputStream())) {
                            os.readBoolean();//wait for ready flag
                        }
                    }
                    catch (IOException e) {
                        e.printStackTrace();
                    }

                    continue;
                }

//                final int count = RepeatCount.getCount(arg);
//                if (count != 0) {
//                    ourRepeatCount = arg;
//                    ourCount = count;
//                    continue;
//                }

                result.add(arg);
            }
        }
        args.clear();
        args.addAll(result);
        if (JUNIT3_RUNNER_NAME.equals(agentName)) {
            try {
                Class.forName("org.junit.runner.Computer");
                agentName = JUNIT4_RUNNER_NAME;
            }
            catch (ClassNotFoundException e) {
                return JUNIT3_RUNNER_NAME;
            }
        }

        if (JUNIT4_RUNNER_NAME.equals(agentName)) {
            try {
                Class.forName("org.junit.Test");
            }
            catch (ClassNotFoundException e) {
                return JUNIT3_RUNNER_NAME;
            }
        }

        try {
            final String forceJUnit3 = System.getProperty("idea.force.junit3");
            if (Boolean.parseBoolean(forceJUnit3)) return JUNIT3_RUNNER_NAME;
        }
        catch (SecurityException ignored) {
        }
        return agentName;
    }

    private static boolean isJUnit5Preferred() {
        return Boolean.parseBoolean(System.getProperty(JUNIT5_KEY));
    }

    public static boolean checkVersion(String[] args, PrintStream printStream) {
        for (String arg : args) {
            if (arg.startsWith(IDE_VERSION)) {
                int ideVersion = Integer.parseInt(arg.substring(IDE_VERSION.length()));
                if (ideVersion != VERSION) {
                    printStream.println("Wrong agent version: " + VERSION + ". IDE expects version: " + ideVersion);
                    printStream.flush();
                    return false;
                }
                return true;
            }
        }
        return false;
    }

    private static boolean canWorkWithJUnitVersion(PrintStream printStream, String agentName) {
        try {
            junitVersionChecks(agentName);
        }
        catch (Throwable e) {
            printStream.println("!!! JUnit version 3.8 or later expected:");
            printStream.println();
            e.printStackTrace(printStream);
            printStream.flush();
            return false;
        }
        finally {
            printStream.flush();
        }
        return true;
    }

    private static void junitVersionChecks(String agentName) throws ClassNotFoundException {
        Class.forName("junit.framework.ComparisonFailure");
        getAgentClass(agentName);
        Class.forName("junit.textui.TestRunner");
    }

    private static int prepareStreamsAndStart(String[] args,
                                              final String agentName,
                                              ArrayList<String> listeners,
                                              String name) {
        try {
//            IdeaTestRunner<?> testRunner = (IdeaTestRunner<?>)getAgentClass(agentName).newInstance();
//            if (ourCommandFileName != null) {
//                if (!"none".equals(ourForkMode) || ourWorkingDirs != null && new File(ourWorkingDirs).length() > 0) {
//                    final List<String> newArgs = new ArrayList<>();
//                    newArgs.add(agentName);
//                    newArgs.addAll(listeners);
//                    return new JUnitForkedSplitter(ourWorkingDirs, ourForkMode, newArgs)
//                            .startSplitting(args, name, ourCommandFileName, ourRepeatCount);
//                }
//            }
//            return IdeaTestRunner.Repeater.startRunnerWithArgs(testRunner, args, listeners, name, ourCount, true);
        }
        catch (Exception e) {
            e.printStackTrace(System.err);
            return -2;
        }
        return 1;
    }

    static Class<?> getAgentClass(String agentName) throws ClassNotFoundException {
        return Class.forName(agentName);
    }

    public static void printClassesList(List<String> classNames, String packageName, String category, String filters, File tempFile)
            throws IOException {

        try (PrintWriter writer = new PrintWriter(new OutputStreamWriter(new FileOutputStream(tempFile), StandardCharsets.UTF_8))) {
            writer.println(packageName); //package name
            writer.println(category); //category
            writer.println(filters); //patterns
            for (String name : classNames) {
                writer.println(name);
            }
        }
    }
}
