package nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import org.junit.jupiter.api.Test;

public class NioEchoServerSample {

    @Test
    void echoServerTest() throws IOException {
        // given
        Selector selector = Selector.open();
        ServerSocketChannel serverSocket = ServerSocketChannel.open();
        serverSocket.bind(new InetSocketAddress("localhost", 1111));
        serverSocket.configureBlocking(false);
        serverSocket.register(selector, SelectionKey.OP_ACCEPT);

        ByteBuffer buffer = ByteBuffer.allocate(256);

        // when
        while (true) {
            selector.select();

            Iterator<SelectionKey> keyIterator = selector.selectedKeys().iterator();

            while (keyIterator.hasNext()) {
                SelectionKey key = keyIterator.next();

                if (key.isAcceptable()) {
                    accept(key);
                } else if (key.isReadable()) {
                    read(buffer, key);
                }

                keyIterator.remove();
            }
        }
    }

    private void accept(SelectionKey key) throws IOException {
        ServerSocketChannel channel = (ServerSocketChannel) key.channel();
        channel.configureBlocking(false);

        channel.register(key.selector(), SelectionKey.OP_READ);
        System.out.println("Connected to client: " + channel.getLocalAddress());
    }

    private static void read(ByteBuffer buffer, SelectionKey key) throws IOException {
        SocketChannel socketChannel = (SocketChannel) key.channel();
        int bytesRead = socketChannel.read(buffer);

        if (bytesRead == -1) {
            System.out.println("Client disconnected: " + socketChannel.getRemoteAddress());
            socketChannel.close();
            key.cancel();
            return;
        }

        buffer.flip();
        System.out.println("Received: " + new String(buffer.array(), 0, buffer.limit()));
        socketChannel.write(buffer);
        buffer.clear();
    }
}
