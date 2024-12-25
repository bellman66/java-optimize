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

    public static void main(String[] args) {
        Path path = Paths.get(System.getProperty("user.dir"), "src", "main", "resources", "WEB-INF", "classes");

        try {
            ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
            WatchService watchService = FileSystems.getDefault().newWatchService();

            path.register(watchService, StandardWatchEventKinds.ENTRY_CREATE, StandardWatchEventKinds.ENTRY_MODIFY, StandardWatchEventKinds.ENTRY_DELETE);

            Runnable runnable = () -> {
                WatchKey key = watchService.poll();

                if (key == null) {
                    return;
                }

                for (WatchEvent<?> event : key.pollEvents()) {
                    WatchEvent.Kind<?> kind = event.kind();

                    System.out.println("kind = " + kind);
                }
            };

            executor.scheduleAtFixedRate(runnable, 0, 1, TimeUnit.SECONDS);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
