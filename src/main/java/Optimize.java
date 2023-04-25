public class Optimize {

    public static void main(String[] args) {
        Runtime runtime = Runtime.getRuntime();

        long prevMemory = runtime.freeMemory();
        long startTime = System.currentTimeMillis();

        double sum = 0;
        for (double i = 1; i <= 100_000_00; i++) {
           sum += (Double) i;
        }

        long endTime = System.currentTimeMillis() - startTime;
        long afterMemory = runtime.freeMemory();

        System.out.println("Process Time : " + endTime / 1000.0 + " milli seconds");
        System.out.println("Total / Used Memory : " + prevMemory + " / " + (prevMemory - afterMemory));
    }
}
