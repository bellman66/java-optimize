package implement.howswap.core;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.WatchKey;

public class ClassWatcher extends Watcher {

    private Runnable callback;

    public ClassWatcher(Path path, Runnable callback) throws IOException {
        super(path);
        this.callback = callback;
    }

    @Override
    public Runnable taskInternal() {
        return () -> {
            WatchKey key = getWatchService().poll();

            if (key == null) {
                return;
            }

            callback.run();
        };
    }
}
