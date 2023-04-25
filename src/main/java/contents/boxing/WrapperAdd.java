package contents.boxing;

import checker.CheckUtil;
import checker.Command;
import contents.common.Optimizer;

public class WrapperAdd extends Optimizer {

    Double sum;

    public WrapperAdd(double sum) {
        this.sum = sum;
    }

    @Override
    protected void run() {
        for (double i = 1; i <= 100_000_00; i++) {
            sum += i;
        }
    }

    public static void main(String[] args) {
        WrapperAdd runner = new WrapperAdd(0);
        Command command = CheckUtil.create(runner::run);

        command.execute();
    }
}
