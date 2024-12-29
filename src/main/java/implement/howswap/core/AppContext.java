package implement.howswap.core;

public class AppContext {

    private ClassLoader classLoader;

    public AppContext(ClassLoader classLoader) {
        this.classLoader = classLoader;
    }

    public ClassLoader getClassLoader() {
        return classLoader;
    }
}
