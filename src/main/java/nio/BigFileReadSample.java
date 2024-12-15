package nio;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BigFileReadSample {


    @Test
    void MemoryMappedFileTest() {
        // given
        String path = System.getProperty("user.dir") + "/src/main/java/nio/example.txt";

        File file = new File(path);

        if (!file.exists()) {
            throw new RuntimeException("File not found");
        }

        String result;

        // when
        try (
                RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
                FileChannel fileChannel = randomAccessFile.getChannel();
        ) {
            // map file to memory
            MappedByteBuffer buffer = fileChannel.map(FileChannel.MapMode.READ_WRITE, 0, randomAccessFile.length());

            // 쓰기
            StringBuilder sb = new StringBuilder();
            while (buffer.hasRemaining()) {
                sb.append((char) buffer.get());
            }

            result = sb.toString();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // then
        Assertions.assertTrue(result.contains("hello world"));
    }

    @Test
    void chunkMemoryMappedSample() {
        // given
        String path = System.getProperty("user.dir") + "/src/main/java/nio/example.txt";
        long chunkSize = 1024 * 1024;    // 1MB

        File file = new File(path);

        if (!file.exists()) {
            throw new RuntimeException("File not found");
        }

        String result;

        // then
        try (
                RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
                FileChannel fileChannel = randomAccessFile.getChannel();
        ) {
            long position = 0;
            long fileSize = fileChannel.size();

            StringBuilder sb = new StringBuilder();
            while (position < fileSize) {
                long size = Math.min(chunkSize, fileSize - position);

                MappedByteBuffer buffer = fileChannel.map(FileChannel.MapMode.READ_WRITE, position, size);

                while (buffer.hasRemaining()) {
                    sb.append((char) buffer.get());
                }

                position += size;
            }

            result = sb.toString();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // then
        Assertions.assertTrue(result.contains("hello world"));
    }

}
