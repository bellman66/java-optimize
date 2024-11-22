package lang.reflect;

import java.lang.reflect.Proxy;
import org.junit.jupiter.api.Test;

public class ProxySample {

    interface Print {

        void print();
    }


    class ProxyTarget implements Print {

        private String title;

        public ProxyTarget(String title) {
            this.title = title;
        }

        @Override
        public void print() {
            System.out.println(title + " proxy method");

        }
    }

    @Test
    void proxyTest() {
        // given
        ProxyTarget proxyTarget = new ProxyTarget("jack");

        Print printMethod = (Print) Proxy.newProxyInstance(ProxySample.class.getClassLoader(),
                new Class[] {Print.class},
                (proxy, method, args) -> {
                    String name = method.getName();

                    switch (name) {
                        case "print":
                            System.out.println("print method");
                            break;
                        default:
                            throw new UnsupportedOperationException("Unsupported method: " + name);
                    }

                    return method.invoke(proxyTarget, args);
                });

        // when
        printMethod.print();
    }
}
