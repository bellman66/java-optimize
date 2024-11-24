package lang.reflect;

import java.lang.reflect.Method;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CglibProxySample {

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

    static class PrintInterceptor implements MethodInterceptor {

        private final Executor executor;

        PrintInterceptor(Executor executor) {
            this.executor = executor;
        }

        @Override
        public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
            return proxy.invoke(executor, args);
        }
    }

    /**
     * defineClass가 protected 상태이기 때문에 접근시 에러가 발생한다.
     * Unable to make protected final java.lang.Class java.lang.ClassLoader.defineClass(java.lang.String,byte[],int,int,java.security.ProtectionDomain) throws java.lang
     *
     * 옵션을 통해 java.base, lang 패키지를 모두 열어주면 접근이 가능하다.
     * --add-opens java.base/java.lang=ALL-UNNAMED
     */
    @Test
    void cglibProxy() {
        // given
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(ProxyTarget.class);
        enhancer.setCallback(new PrintInterceptor(new ProxyTarget()));

        // when
        Executor result = (Executor) enhancer.create();
        result.addValue(10);
        result.addValue(20);

        // then
        Assertions.assertEquals(30, result.getTotal());
    }
}
