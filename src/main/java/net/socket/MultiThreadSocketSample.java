package net.socket;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MultiThreadSocketSample {

    class ServerTask implements Runnable {
        private final Socket socket;

        private ServerTask(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try (
                    BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            ) {
                String message = reader.readLine();

                System.out.println("Received message : " + message);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    void multiThreadSocketTest() {
        // given
        final int port = 1111;
        final ExecutorService executorService = Executors.newFixedThreadPool(10);

        // when
        try (
                ServerSocket server = new ServerSocket(port)
        ) {
            while (!server.isClosed()) {
                try {
                    Socket client = server.accept();

                    System.out.println("access from " + client.getRemoteSocketAddress());

                    executorService.execute(new ServerTask(client));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // then
    }
}
