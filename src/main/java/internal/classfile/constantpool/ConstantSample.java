package internal.classfile.constantpool;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ConstantSample {

    @Test
    void getMagicNumberAndVersion() {
        // given
        String path = System.getProperty("user.dir");
        Path path1 = Paths.get("build", "classes", "java", "main", "internal", "classfile", "constantpool", "ConstantSample.class");
        String classPath = path1.toAbsolutePath().toString();

        // when
        int magic;
        int minorVersion;
        int majorVersion;

        try (
                DataInputStream dataInputStream = new DataInputStream(new FileInputStream(classPath));
        ) {
            magic = dataInputStream.readInt();
            minorVersion = dataInputStream.readUnsignedShort();
            majorVersion = dataInputStream.readUnsignedShort();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // then
        Assertions.assertEquals(0xCAFEBABE, magic);
        Assertions.assertEquals(0, minorVersion);
        Assertions.assertEquals(61, majorVersion);
    }
}
