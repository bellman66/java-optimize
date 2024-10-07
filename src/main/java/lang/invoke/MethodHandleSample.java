package lang.invoke;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MethodHandleSample {

    // call field
    public String message = "Initial Message";

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

    @Test
    public void testMethodHandleFieldGetter() throws Throwable {
        // Lookup 객체 생성
        MethodHandles.Lookup lookup = MethodHandles.lookup();

        // 필드에 대한 MethodHandle 생성 (getter)
        MethodHandle getter = lookup.findGetter(MethodHandleSample.class, "message", String.class);

        String fieldValue = (String) getter.invoke(this);

        assertEquals(fieldValue, "Initial Message");
    }

    @Test
    public void testMethodHandleFieldSetter() throws Throwable {
        // Lookup 객체 생성
        MethodHandles.Lookup lookup = MethodHandles.lookup();

        // 필드에 대한 MethodHandle 생성 (Setter)
        MethodHandle setter = lookup.findSetter(MethodHandleSample.class, "message", String.class);

        setter.invoke(this, "Changed Message");

        assertEquals(message, "Changed Message");
    }
}
