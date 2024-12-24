package Lab3;

public class Task5 {
    public static void main(String[] args) {
        printResults(0.5, 5);
        printResults(1, 5);
        printResults(0.5, -1); // Має викликати помилку
    }

    public static double calculateSeries(double x, int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("n must be greater than 0, but got: " + n);
        }
        if (x == 1) {
            return n + 1;
        }
        return (1 - Math.pow(x, n + 1)) / (1 - x);
    }

    static void printResults(double x, int n) {
        System.out.print("x:" + x + " n:" + n + " result:");
        try {
            System.out.println(calculateSeries(x, n));
        } catch (IllegalArgumentException e) {
            System.out.println("EXCEPTION! " + e.getMessage());
        }
    }
}
