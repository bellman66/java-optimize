package checker.impl;

import checker.Command;
import checker.Commander;

public class Timer extends Commander {

    public Timer(Command command) {
        super(command);
    }

    @Override
    public void execute() {
        long startTime = System.currentTimeMillis();

        // Execute
        super.run();

        long endTime = System.currentTimeMillis() - startTime;
        System.out.println("Process Time : " + endTime / 1000.0 + " milli seconds");
    }
}
