package internal.classfile.constantpool;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ConstantSample {

    @Test
    void getMagicNumberAndVersion() {
        // given
        Path path = Paths.get("build", "classes", "java", "main", "internal", "classfile", "constantpool", "ConstantSample.class");
        String classPath = path.toAbsolutePath().toString();

        // when
        int magic;
        int minorVersion;
        int majorVersion;
        int constantPoolCount;

        try (
                DataInputStream dataInputStream = new DataInputStream(new FileInputStream(classPath));
        ) {
            magic = dataInputStream.readInt();
            minorVersion = dataInputStream.readUnsignedShort();
            majorVersion = dataInputStream.readUnsignedShort();
            constantPoolCount = dataInputStream.readUnsignedShort();

            for (int i = 0; i < constantPoolCount; i++) {
                switch (dataInputStream.readUnsignedByte()) {
                    case 1: // CONSTANT_Utf8
                        byte[] bytes = new byte[dataInputStream.readUnsignedShort()];
                        dataInputStream.readFully(bytes);
                        String utf8 = new String(bytes, "UTF-8");
                        System.out.println("#" + i + " CONSTANT_Utf8: " + utf8);
                        break;
                    case 3: // CONSTANT_Integer
                        int intValue = dataInputStream.readInt();
                        System.out.println("#" + i + " CONSTANT_Integer: " + intValue);
                        break;
                    case 4: // CONSTANT_Float
                        float floatValue = dataInputStream.readFloat();
                        System.out.println("#" + i + " CONSTANT_Float: " + floatValue);
                        break;
                    case 5: // CONSTANT_Long
                        long longValue = dataInputStream.readLong();
                        System.out.println("#" + i + " CONSTANT_Long: " + longValue);
                        i++; // Long and double take two entries
                        break;
                    case 6: // CONSTANT_Double
                        double doubleValue = dataInputStream.readDouble();
                        System.out.println("#" + i + " CONSTANT_Double: " + doubleValue);
                        i++; // Long and double take two entries
                        break;
                    case 7: // CONSTANT_Class
                        int classIndex = dataInputStream.readUnsignedShort();
                        System.out.println("#" + i + " CONSTANT_Class: #" + classIndex);
                        break;
                    case 8: // CONSTANT_String
                        int stringIndex = dataInputStream.readUnsignedShort();
                        System.out.println("#" + i + " CONSTANT_String: #" + stringIndex);
                        break;
                    case 9: // CONSTANT_Fieldref
                    case 10: // CONSTANT_Methodref
                    case 11: // CONSTANT_InterfaceMethodref
                        int classRefIndex = dataInputStream.readUnsignedShort();
                        int nameAndTypeIndex = dataInputStream.readUnsignedShort();
                        System.out.println("#" + i + " CONSTANT_Ref: classIndex=#" + classRefIndex + ", nameAndTypeIndex=#" + nameAndTypeIndex);
                        break;
                    case 12: // CONSTANT_NameAndType
                        int nameIndex = dataInputStream.readUnsignedShort();
                        int descriptorIndex = dataInputStream.readUnsignedShort();
                        System.out.println("#" + i + " CONSTANT_NameAndType: nameIndex=#" + nameIndex + ", descriptorIndex=#" + descriptorIndex);
                        break;
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // then
        assertEquals(0xCAFEBABE, magic);
        assertEquals(0, minorVersion);
        assertEquals(61, majorVersion);
        assertEquals(214, constantPoolCount);
    }
}
