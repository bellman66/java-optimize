package origin.jep306_strictfp;

public class example {

    public static strictfp class ScientificCalculator {

        public ScientificCalculator() {
        }

        public  double sum(double value1, double value2) {
            return value1 + value2;
        }

        public double diff(double value1, double value2) {
            return value1 - value2;
        }
    }

    public static void main(String[] args) {
        ScientificCalculator calculator = new ScientificCalculator();
        double sum = calculator.sum(0.1, 0.2);
        double diff = calculator.diff(0.1, 0.2);

        System.out.println("sum: " + sum);
        System.out.println("diff: " + diff);
    }
}
