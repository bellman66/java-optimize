package util.concurrent.locks.builtin;


import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.locks.Lock;

public class MultiLock {

    private final List<Lock> lockGroup;

    public MultiLock(Lock... locks) {
        this.lockGroup = Arrays.asList(locks);
        this.lockGroup.sort(Comparator.comparingInt(System::identityHashCode));
    }

    public void lockAll() {
        lockGroup.forEach(Lock::lock);
    }

    public void unlockAll() {
        lockGroup.forEach(Lock::unlock);
    }
}
