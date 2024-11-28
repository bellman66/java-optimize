package internal.jimage;

import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.junit.jupiter.api.Test;

public class ModulePathSample {

    @Test
    void checkModulePath() {
        try {
            // given
            URI uri = URI.create("jrt:/");
            String modulePath = "/modules";

            // then
            Path path = Paths.get(uri).resolve(modulePath);
            Files.list(path).forEach(System.out::println);
        } catch (Exception e) {
            System.err.println("Error exploring JImage: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
