package spring;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.support.StaticApplicationContext;

public class Context {

    static class TestBean {
        private String name;

        public TestBean() {
            name = "default";
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return String.format("hashCode: %d, name: %s", this.hashCode(), name);
        }
    }

    @DisplayName("정적 스프링 컨텍스트 등록 - BeanDefinition")
    @Test
    void registerBeanDefinitionContext() {
        StaticApplicationContext context = new StaticApplicationContext();

        RootBeanDefinition rootBeanDefinition = new RootBeanDefinition(TestBean.class);
        rootBeanDefinition.getPropertyValues().addPropertyValue("name", "change name");

        context.registerSingleton("testbean", TestBean.class);
        context.registerBeanDefinition("testbean", rootBeanDefinition);

        TestBean testbean1 = context.getBean("testbean", TestBean.class);
        Assertions.assertEquals(testbean1.toString(), "hashCode: " + testbean1.hashCode() + ", name: change name");
    }
}
