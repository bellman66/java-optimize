package implement;

import implement.howswap.core.AppClassLoader;
import implement.howswap.core.AppContext;
import implement.howswap.core.ClassWatcher;
import implement.howswap.core.Watcher;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class HotSwap {

    private static final Path PATH = Paths.get(System.getProperty("user.dir"), "src", "main", "resources", "WEB-INF", "classes");

    private static AppContext context;

    public static Runnable RESET_CONTEXT = () -> {
        System.out.println("reset application context");
        context = new AppContext(new AppClassLoader(PATH));
    };

    public static void main(String[] args) {
        try {
            ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
            RESET_CONTEXT.run();

            Watcher watch = new ClassWatcher(PATH, RESET_CONTEXT);

            executor.scheduleAtFixedRate(watch.getTask(), 0, 1, TimeUnit.SECONDS);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
