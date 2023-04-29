package contents.enums.strategy;

import static contents.enums.strategy.PayDay.PayType.*;

public enum PayDay {
    MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY,
    SATUREDAY(WEEKEND), SUNDAY(WEEKEND);

    private final PayType payType;

    PayDay() {
        this.payType = WEEKDAY;
    }

    PayDay(PayType payType) {
        this.payType = payType;
    }

    public int calculatePay(int min, int payRate) {
        return payType.pay(min, payRate);
    }

    enum PayType {
        WEEKDAY {
            @Override
            int overtimePay(int min, int payRate) {
                return min > DEFAULT_WORK_MIN ? (min - DEFAULT_WORK_MIN) * (payRate / 2) : 0;
            }
        },
        WEEKEND {
            @Override
            int overtimePay(int min, int payRate) {
                return min * (payRate / 2);
            }
        };

        private static int DEFAULT_WORK_MIN = 8 * 60;
        abstract int overtimePay(int min, int payRate);

        public int pay(int min, int payRate) {
            int basePay = min * payRate;
            return basePay + overtimePay(min, payRate);
        }
    }
}
