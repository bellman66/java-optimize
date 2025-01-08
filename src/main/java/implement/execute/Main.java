package implement.execute;

import implement.execute.core.JavaclassExecuter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {

    public static void main(String[] args) throws IOException {
        Path path = Paths.get(System.getProperty("user.dir"), "src", "main", "resources", "WEB-INF", "classes", "JITCompileSample.class");
        InputStream is = new FileInputStream(path.toFile());
        byte[] classBytes = new byte[is.available()];

        is.read(classBytes);
        is.close();

        String result = JavaclassExecuter.execute(classBytes);
        System.out.println(result);
    }
}
