package net.socket;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import org.junit.jupiter.api.Test;

public class UdpSample {

    @Test
    void receiveDatagram() {
        // given
        String host = "localhost";
        int port = 8080;

        // when
        try (
                DatagramSocket socket = new DatagramSocket(new InetSocketAddress(host, port));
        ) {
            byte[] buffer = new byte[1024];

            while (true) {
                DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
                socket.receive(packet);

                String body = new String(packet.getData());
                System.out.println(packet.getAddress() + " : " + body);

                // response
                String responseBody = "Hello, World! " + packet.getAddress();
                byte[] responseBodyBytes = responseBody.getBytes();

                DatagramPacket response = new DatagramPacket(responseBodyBytes, responseBodyBytes.length, packet.getAddress(), packet.getPort());
                socket.send(response);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void sendDatagram() {
        // given
        String host = "localhost";
        int port = 8080;

        // when
        try (
                DatagramSocket socket = new DatagramSocket();
        ) {
            byte[] data = "Hello, World!".getBytes();
            DatagramPacket packet = new DatagramPacket(data, data.length, new InetSocketAddress(host, port));
            socket.send(packet);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
