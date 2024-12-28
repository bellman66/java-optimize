package implement.howswap.core;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;

public class ClassWatcher extends Watcher {

    public ClassWatcher(Path path) throws IOException {
        super(path);
    }

    @Override
    public Runnable taskInternal() {
        return () -> {
            WatchKey key = getWatchService().poll();

            if (key == null) {
                return;
            }

            for (WatchEvent<?> event : key.pollEvents()) {
                WatchEvent.Kind<?> kind = event.kind();

                System.out.println("kind = " + kind);
            }
        };
    }
}
