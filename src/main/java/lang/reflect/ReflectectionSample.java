package lang.reflect;

import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectectionSample {

    static class TestClass {
        private String title = "default";

        public void say(String message) {
            System.out.println(title + " say: " + message);
        }
    }

    @Test
    void reflectionTest() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Class<?> targetClass = TestClass.class;

        Method method = targetClass.getDeclaredMethod("say", String.class);

        method.invoke(new TestClass(), "Hello, World!");
    }
}
