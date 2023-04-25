package checker;

import checker.impl.MemoryChecker;
import checker.impl.Timer;

public class CheckUtil {

    public static Command create(Command function) {
        return new MemoryChecker(new Timer(function));
    }
}
