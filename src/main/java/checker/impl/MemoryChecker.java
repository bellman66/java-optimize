package checker.impl;

import checker.Command;
import checker.Commander;

public class MemoryChecker extends Commander {

    public MemoryChecker(Command command) {
        super(command);
    }

    @Override
    public void execute() {
        Runtime runtime = Runtime.getRuntime();
        long prevMemory = runtime.freeMemory();

        // Execute
        super.run();

        long afterMemory = runtime.freeMemory();
        System.out.println("Total / Used Memory : " + prevMemory + " / " + (prevMemory - afterMemory));
    }
}
