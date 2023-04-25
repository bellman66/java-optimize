package enums;

public enum Calculate {
    SUM ("+") { public int apply(int a, int b) { return a + b; } },
    MINUS ("-") { public int apply(int a, int b) { return a - b; } },
    DIV ("/") { public int apply(int a, int b) { return a / b; } },
    MULTI ("*") { public int apply(int a, int b) { return a * b; } };

    private final String symbol;

    Calculate(String symbol) {
        this.symbol = symbol;
    }

    public abstract int apply(int a, int b);
}
