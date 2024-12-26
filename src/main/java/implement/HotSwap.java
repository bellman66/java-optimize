package implement;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class HotSwap {

    static class Watch {

        private static final WatchEvent.Kind<?>[] DEFAULT_EVENT = {StandardWatchEventKinds.ENTRY_CREATE, StandardWatchEventKinds.ENTRY_MODIFY, StandardWatchEventKinds.ENTRY_DELETE};

        private Path path;
        private WatchService watchService;
        private Runnable task;

        Watch(Path path) throws IOException {
            this.path = path;
            this.watchService = FileSystems.getDefault().newWatchService();
            register(DEFAULT_EVENT);
        }

        Watch(Path path, WatchEvent.Kind<?>... events) throws IOException {
            this.path = path;
            this.watchService = FileSystems.getDefault().newWatchService();
            register(events);
        }

        private void register(WatchEvent.Kind<?>... events) throws IOException {
            path.register(watchService, events);

            task = () -> {
                WatchKey key = watchService.poll();

                if (key == null) {
                    return;
                }

                for (WatchEvent<?> event : key.pollEvents()) {
                    WatchEvent.Kind<?> kind = event.kind();

                    System.out.println("kind = " + kind);
                }
            };
        }

        public Runnable getTask() {
            return task;
        }
    }

    public static void main(String[] args) {
        Path path = Paths.get(System.getProperty("user.dir"), "src", "main", "resources", "WEB-INF", "classes");

        try {
            ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();

            Watch watch = new Watch(path);

            executor.scheduleAtFixedRate(watch.getTask(), 0, 1, TimeUnit.SECONDS);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
