package net.socket;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import org.junit.jupiter.api.Test;

public class SocketSample {

    @Test
    void socketInputStreamTest() {
        // given
        int socketPort = 1111;
        int bufferSize = 1024;

        // when
        try (
                ServerSocket serverSocket = new ServerSocket(socketPort);
        ) {
            System.out.println("Server is running...");

            while (true) {
                try (
                        Socket socket = serverSocket.accept();
                        InputStream is = socket.getInputStream();
                ) {
                    byte[] buffer = new byte[bufferSize];
                    int size = is.read(buffer);

                    String message = new String(buffer, 0, size, StandardCharsets.UTF_8);
                    System.out.println("Received message : " + message);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // then
    }
}
