package Lab4;

public class PositiveCountlndexMultiple4 {
    public static void main(String[] args) {
        int[] array = {3, -5, 8, 0, 15, -2, 7, -4, 10};
        System.out.println("Кількість додатних елементів з індексами, кратними 4: " + countPositive(array));
    }

    public static int countPositive(int[] array) {
        if (array == null) {
            throw new NullPointerException("Масив не може бути null.");
        }

        int count = 0;
        for (int i = 0; i < array.length; i += 4) {
            if (array[i] > 0) {
                count++;
            }
        }
        return count;
    }
}
