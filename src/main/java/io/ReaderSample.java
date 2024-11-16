package io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;
import org.junit.jupiter.api.Test;

public class ReaderSample {

    @Test
    void bufferedReaderTest() {
        // given
        String path = System.getProperty("user.dir") + "/src/main/java/io/example.txt";
        File file = new File(path);

        if (!file.exists()) {
            throw new RuntimeException("File not found");
        }

        // when
        try (
                FileInputStream fileInputStream = new FileInputStream(file);
                InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        ) {
            String line;
            while (((line = bufferedReader.readLine()) != null)) {
                System.out.println(line);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // then
    }

    @Test
    void zipFileReaderTest() {
        // given
        String path = System.getProperty("user.dir") + "/src/main/java/io/example.txt";
        File file = new File(path);

        if (!file.exists()) {
            throw new RuntimeException("File not found");
        }

        // when
        String zipFileName = "example.zip";
        byte[] buf = new byte[1024];
        try (
                FileOutputStream fileOutputStream = new FileOutputStream( zipFileName);
                ZipOutputStream zipOutputStream = new ZipOutputStream(fileOutputStream);
        ) {
            // open origin file
            try (
                    FileInputStream fileInputStream = new FileInputStream(file);
            ) {
                ZipEntry zipEntry = new ZipEntry(file.getName());
                zipOutputStream.putNextEntry(zipEntry);

                int length;
                while (((length = fileInputStream.read()) > 0)) {
                    zipOutputStream.write(buf, 0, length);
                }
            }

            zipOutputStream.closeEntry();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
