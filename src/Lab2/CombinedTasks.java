package Lab2;

public class CombinedTasks {
    public static void main(String[] args) {
        // Завдання 1 (16)
        double a1 = 0.58, b1 = 0.34, c1 = 1.25, d1 = -1.89;
        double result1 = (a1 + b1) * (c1 - d1);
        System.out.println("Результат завдання 1: " + result1);

        // Завдання 2 (28)
        double a2 = 1.478, b2 = 9.26, c2 = 0.68, d2 = 2.24;
        double result2 = Math.pow(a2, 2) + b2 / (c2 * d2);
        System.out.println("Результат завдання 2: " + result2);

        // Завдання 3 (17)
        double a3 = -1.49, b3 = 23.4, c3 = 1.23, d3 = 2.254;
        double result3 = a3 > b3 ? c3 + d3 : c3 - d3;
        System.out.println("Результат завдання 3: " + result3);
    }
}
