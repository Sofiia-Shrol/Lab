package Lab3;

public class Task9 {
    public static void main(String[] args) {
        printResults(0);
        printResults(Math.PI / 4);
        printResults(Math.PI / 2); // Має викликати помилку
    }

    public static double calculateFunction(double x) {
        if (Math.abs(x % Math.PI - Math.PI / 2) < 1e-9) {
            throw new IllegalArgumentException("tan(x) is undefined for x = " + x);
        }
        return Math.sin(x) + Math.cos(x) + Math.tan(x);
    }

    static void printResults(double x) {
        System.out.print("x:" + x + " result:");
        try {
            System.out.println(calculateFunction(x));
        } catch (IllegalArgumentException e) {
            System.out.println("EXCEPTION! " + e.getMessage());
        }
    }
}
