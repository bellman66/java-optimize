package implement.hotswap.core;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class AppClassLoader extends ClassLoader {

    private final Path classPath;

    public AppClassLoader(Path classPath) {
        this.classPath = classPath;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        try {
            String filePath = classPath + "/" + name.replace(".", "/") + ".class";
            byte[] classData = Files.readAllBytes(Paths.get(filePath));
            return defineClass(name, classData, 0, classData.length);
        } catch (IOException e) {
            throw new ClassNotFoundException(name, e);
        }
    }
}
