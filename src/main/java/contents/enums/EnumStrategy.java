package contents.enums;

import static contents.enums.Calculate.*;

public class EnumStrategy {

    private static int calculate(Calculate symbol, int a, int b) {
        return symbol.apply(a, b);
    }

    public static void main(String[] args) {
        int a = 5;
        int b = 10;

        System.out.println("SUM : " + calculate(SUM, a, b));
        System.out.println("MINUS : " + calculate(MINUS, a, b));
        System.out.println("DIV : " + calculate(DIV, a, b));
        System.out.println("MULTI : " + calculate(MULTI, a, b));
    }
}
