package lang.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;
import java.net.Socket;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AnnotationSample {

    @Documented
    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.METHOD)
    @interface MyAnnotation {
        String value();
    }

    @Documented
    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.METHOD)
    @interface OtherAnnotation {
        String value();
    }

    static class TestClass {

        @MyAnnotation(value = "first method")
        public void callFirstMethod() {
            System.out.println("myMethod 호출됨");
        }

        @MyAnnotation(value = "second method")
        public void callSecondMethod() {
            System.out.println("myMethod 호출됨");
        }

        @OtherAnnotation(value = "third method")
        public void callThirdMethod() {
            System.out.println("myMethod 호출됨");
        }
    }

    @Test
    void checkAnnotation() {
        // given
        TestClass testClass = new TestClass();

        // when
        List<Method> result = Arrays.stream(testClass.getClass().getMethods())
                .filter(method -> method.isAnnotationPresent(MyAnnotation.class))
                .toList();

        // then
        assertEquals(result.size(), 2);
    }

    @Test
    void findMethodNameTest() {
        // given
        TestClass testClass = new TestClass();

        // when
        String result = Arrays.stream(testClass.getClass().getMethods())
                .filter(method -> method.isAnnotationPresent(OtherAnnotation.class))
                .map(Method::getName)
                .collect(Collectors.joining());

        // then
        assertEquals(result, "callThirdMethod");
    }
}
