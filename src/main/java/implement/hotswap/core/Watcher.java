package implement.hotswap.core;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchService;

public abstract class Watcher {

    private static final WatchEvent.Kind<?>[] DEFAULT_EVENT = {StandardWatchEventKinds.ENTRY_CREATE, StandardWatchEventKinds.ENTRY_MODIFY, StandardWatchEventKinds.ENTRY_DELETE};

    private Path path;
    private WatchService watchService;
    private Runnable task;

    Watcher(Path path) throws IOException {
        this.path = path;
        this.watchService = FileSystems.getDefault().newWatchService();
        register(DEFAULT_EVENT);
    }

    private void register(WatchEvent.Kind<?>... events) throws IOException {
        path.register(watchService, events);
        task = taskInternal();
    }

    public WatchService getWatchService() {
        return watchService;
    }

    public abstract Runnable taskInternal();

    public Runnable getTask() {
        return task;
    }
}
