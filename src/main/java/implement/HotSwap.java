package implement;

import implement.howswap.core.ClassWatcher;
import implement.howswap.core.Watcher;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class HotSwap {

    public static void main(String[] args) {
        Path path = Paths.get(System.getProperty("user.dir"), "src", "main", "resources", "WEB-INF", "classes");

        try {
            ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();

            Watcher watch = new ClassWatcher(path);

            executor.scheduleAtFixedRate(watch.getTask(), 0, 1, TimeUnit.SECONDS);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
