package contents.boxing;

import checker.CheckUtil;
import checker.Command;
import contents.common.Optimizer;

public class PrimitiveBoxing extends Optimizer {

    double sum;

    public PrimitiveBoxing(double sum) {
        this.sum = sum;
    }

    /**
    *   @Author : Youn
    *   @Summary : Auto Boxing Test
    *   @Memo : 속도 보다는 메모리 문제발생
    **/
    @Override
    protected void run() {
        for (double i = 1; i <= 100_000_00; i++) {
            sum += (Double) i;
        }
    }

    public static void main(String[] args) {
        PrimitiveBoxing runner = new PrimitiveBoxing(0);
        Command command = CheckUtil.create(runner::run);

        command.execute();
    }
}
