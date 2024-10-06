package lang.invoke;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import org.junit.jupiter.api.Test;

public class MethodHandleSample {

    // call target method
    public static void printHelloWorld(String name) {
        System.out.println("Hello world, " + name + "!");
    }

    @Test
    public void testMethodHandle() throws Throwable {
        MethodHandles.Lookup lookup = MethodHandles.lookup();

        MethodType methodType = MethodType.methodType(void.class, String.class);

        MethodHandle methodHandle = lookup.findStatic(MethodHandleSample.class, "printHelloWorld", methodType);

        methodHandle.invokeExact("Youn");
    }
}
