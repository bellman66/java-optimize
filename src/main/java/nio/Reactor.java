package nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.util.Set;
import nio.builtin.AcceptHandler;

public class Reactor implements Runnable {

    private final Selector selector;
    private final ServerSocketChannel serverSocketChannel;

    public Reactor(int port) throws IOException {
        selector = Selector.open();

        serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.bind(new InetSocketAddress(port));
        serverSocketChannel.configureBlocking(false);

        SelectionKey selectionKey = serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        selectionKey.attach(new AcceptHandler(selector, serverSocketChannel));
    }

    @Override
    public void run() {
        try {
            while (true) {
                selector.select();
                Set<SelectionKey> selectionKeyGroup = selector.selectedKeys();

                for (SelectionKey selectionKey : selectionKeyGroup) {
                    dispatch(selectionKey);
                }

                selectionKeyGroup.clear();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    void dispatch(SelectionKey selectionKey) {
        Runnable handler = (Runnable) selectionKey.attachment();
        handler.run();
    }
}
