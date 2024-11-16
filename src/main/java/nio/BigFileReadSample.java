package nio;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
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

            System.out.println(sb);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
