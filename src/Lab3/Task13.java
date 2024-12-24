package Lab3;

public class Task13 {
    public static void main(String[] args) {
        printResults(0.0001);
        printResults(0);
        printResults(160);
    }

    public double task(double eps) {
        if (eps <= 0) {
            throw new IllegalArgumentException("param eps = " + eps);
        }
        double sum = 0;
        double term = 1;
        int i = 1;
        while (Math.abs(term) >= eps) {
            sum += term;
            i++;
            term = Math.pow(-1, i) / factorial(i);
        }
        return sum;
    }

    public static int factorial(int x) {
        int result = 1;
        for (int i = 2; i <= x; i++) {
            result *= i;
        }
        return result;
    }

    static void printResults(double eps) {
        System.out.print("eps:" + eps + " result:");
        try {
            Task13 result = new Task13();
            System.out.println(result.task(eps));
        }
        catch (IllegalArgumentException e) {
            System.out.println("EXCEPTION! " + e.getMessage());
        }
    }
}
