package lang.Classloader;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ClassLoaderSample {

    /**
     * ClassLoaders -> AppClassLoader
     * Start to JNI_CreateJavaVM Call
     *
     * @param
     * @return
     * @throws
     * @see https://www.ibm.com/docs/ko/i/7.3?topic=api-example-java-invocation
     */
    @Test
    void createClassLoader() {
        // given
        // ClassLoaders -> AppClassLoader
        ClassLoader classLoader = ClassLoaderSample.class.getClassLoader();

        // when
        ClassLoader platform = classLoader.getParent();

        // then
        assertEquals("jdk.internal.loader.ClassLoaders$AppClassLoader", classLoader.getClass().getName());
        assertEquals("jdk.internal.loader.ClassLoaders$PlatformClassLoader", platform.getClass().getName());
    }
}