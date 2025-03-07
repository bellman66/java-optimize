package compiler;

public class JITPrintSample {

    public static int doubleValue(int a) {
        for (int i=0; i<10000; i++);
        return a * 2;
    }

    public static int calcutate() {
        int sum = 0;
        for (int i=0; i<100; i++) {
            sum += doubleValue(i);
        }
        return sum;
    }

    public static void main(String[] args) {
        for (int i=0; i<100; i++) {
            System.out.println(i + " = " + calcutate());
        }
    }
}
