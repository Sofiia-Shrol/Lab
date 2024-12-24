package Lab6;

public class IntToHexConverter {
    public static void main(String[] args) {
        // Тестування з різними значеннями
        System.out.println(intToHexString(51966)); // Очікується: "CAFE"
        System.out.println(intToHexString(255));   // Очікується: "FF"
        System.out.println(intToHexString(0));     // Очікується: "0"

        // Неправильне значення (наприклад, негативне)
        try {
            System.out.println(intToHexString(-1));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public static String intToHexString(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("Number must be non-negative.");
        }
        return Integer.toHexString(i).toUpperCase();
    }
}
