package nio;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import org.junit.jupiter.api.Test;

public class ChannelSample {

    @Test
    void FileChannelTest() {
        // given
        Path path = Path.of(System.getProperty("user.dir"), "src", "main", "java", "nio", "example.txt");

        // when
        try (
                FileChannel fileChannel = FileChannel.open(path, StandardOpenOption.READ)
        ) {
            ByteBuffer buffer = ByteBuffer.allocate(1024);

            while (fileChannel.read(buffer) != -1) {
                buffer.flip();

                while (buffer.hasRemaining()) {
                    System.out.print((char) buffer.get());
                }

                buffer.clear();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
