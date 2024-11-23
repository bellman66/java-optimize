package lang.reflect;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CacheProxySample {

    interface Executor {

        void addValue(int value);

        int getTotal();
    }


    static class ProxyTarget implements Executor {

        private int total = 0;

        public ProxyTarget() {
        }

        @Override
        public void addValue(int value) {
            total += value;
        }

        @Override
        public int getTotal() {
            return total;
        }
    }

    static class CalculateInvocationHandler implements InvocationHandler {

        private final Executor executor;

        public CalculateInvocationHandler(Executor executor) {
            this.executor = executor;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws InvocationTargetException, IllegalAccessException {
            switch (method.getName()) {
                case "addValue":
                    System.out.println("execute addValue method: " + args[0]);
                    break;
                case "getTotal":
                    System.out.println("execute getTotal method");
                    break;
                default:
                    throw new UnsupportedOperationException("Unsupported method: " + method.getName());
            }
            return method.invoke(executor, args);
        }
    }

    @Test
    void cacheProxyTest() {
        // given
        Executor proxy = (Executor) Proxy.newProxyInstance(CacheProxySample.class.getClassLoader(),
                new Class[] {Executor.class},
                new CalculateInvocationHandler(new ProxyTarget())
        );

        // when
        proxy.addValue(10);
        proxy.addValue(20);

        Assertions.assertEquals(30, proxy.getTotal());
    }
}
