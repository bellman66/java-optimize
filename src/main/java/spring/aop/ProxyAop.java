package spring.aop;

import java.lang.reflect.Proxy;
import org.junit.jupiter.api.Test;

public class ProxyAop {

    interface Data {

        void defaultCall();

        void extendCall();
    }

    static class TestData implements Data {
        private String name;
        private int age;

        public TestData(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public void defaultCall() {
            System.out.println("default call");
        }

        @Override
        public void extendCall() {
            System.out.println("extend call");
        }
    }

    @Test
    void generateProxy() {
        // given
        TestData realData = new TestData("test", 10);

        Data testData = (Data) Proxy.newProxyInstance(Data.class.getClassLoader()
                , new Class[] {Data.class}
                , (proxy, method, args) -> {
                    if (method.getName().equals("extendCall")) {
                        System.out.println("previous extend proxy");
                    }
                    return method.invoke(realData, args);
                });

        // print default call
        testData.defaultCall();

        // print previous + extend call
        testData.extendCall();
    }
}
