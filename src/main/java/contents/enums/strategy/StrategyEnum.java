package contents.enums.strategy;

public class StrategyEnum {

    public static void main(String[] args) {
        PayDay monday = PayDay.MONDAY;
        PayDay sunday = PayDay.SUNDAY;

        int res1 = monday.calculatePay(520, 60);
        int res2 = sunday.calculatePay(480, 60);

        System.out.println("res1 = " + res1);
        System.out.println("res2 = " + res2);
    }
}
