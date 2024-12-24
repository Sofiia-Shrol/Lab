package Lab4;

import java.util.Arrays;

public class SecondMinByAbs {
    public static void main(String[] args) {
        int[] array = {3, -7, 2, 9, -2};
        try {
            System.out.println("Другий мінімальний за модулем елемент: " + findSecondMinByAbs(array));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public static int findSecondMinByAbs(int[] array) {
        if (array == null || array.length < 2) {
            throw new IllegalArgumentException("Масив повинен мати щонайменше два елементи.");
        }

        int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;

        for (int num : array) {
            int absNum = Math.abs(num);
            if (absNum < Math.abs(min1)) {
                min2 = min1;
                min1 = num;
            } else if (absNum < Math.abs(min2) && absNum != Math.abs(min1)) {
                min2 = num;
            }
        }

        if (min2 == Integer.MAX_VALUE) {
            throw new IllegalArgumentException("Другого мінімального за модулем елемента не знайдено.");
        }

        return min2;
    }
}

