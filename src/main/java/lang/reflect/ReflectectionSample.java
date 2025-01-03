package lang.reflect;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;

public class ReflectectionSample {

    static class TestClass {
        private String title;

        public TestClass(String title) {
            this.title = title;
        }

        public void say(String message) {
            System.out.println(title + " say: " + message);
        }
    }

    @Test
    void methodReflectionTest() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Class<?> targetClass = TestClass.class;

        Method method = targetClass.getDeclaredMethod("say", String.class);

        method.invoke(new TestClass("jack"), "Hello, World!");
    }

    @Test
    void constructorReflectionTest() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {
        Class<?> targetClass = TestClass.class;

        Constructor<?> constructor = targetClass.getConstructor(String.class);

        TestClass testClass = (TestClass) constructor.newInstance("jack");

        assertInstanceOf(TestClass.class, testClass);
    }

    @Test
    void fieldReflectionTest() throws IllegalAccessException, NoSuchFieldException {
        Class<?> targetClass = TestClass.class;
        TestClass testClass = new TestClass("jack");

        Field field = targetClass.getDeclaredField("title");

        field.setAccessible(true);
        String title = (String) field.get(testClass);

        field.set(testClass, "rose");
        String next = (String) field.get(testClass);

        assertEquals(title, "jack");
        assertEquals(next, "rose");
    }
}
