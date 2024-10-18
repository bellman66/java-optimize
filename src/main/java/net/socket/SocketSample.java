package net.socket;

import java.io.DataOutputStream;
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
        int port = 1111;
        int bufferSize = 1024;

        // when
        try (
                ServerSocket serverSocket = new ServerSocket(port);
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
    }

    @Test
    void socketOutputStreamTest() {
        // given
        String host = "127.0.0.1";
        int port = 1111;
        String message = "Hello, Server";

        // when
        try (
                Socket socket = new Socket(host, port);
                DataOutputStream os = new DataOutputStream(socket.getOutputStream());
        ) {
            System.out.println("client connected success...");

            os.writeUTF(message);
            os.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
