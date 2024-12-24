package Lab4;

import java.util.Arrays;

public class TransformArray {
    public static void main(String[] args) {
        int[] array = {3, -5, 0, 7, -2};
        int[] transformedArray = transform(array);

        System.out.println("Перетворений масив: " + Arrays.toString(transformedArray));
    }

    public static int[] transform(int[] array) {
        if (array == null) {
            throw new NullPointerException("Масив не може бути null.");
        }

        int[] result = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            if (array[i] < 0) {
                result[i] = array[i] * -1;
            } else if (array[i] > 0) {
                result[i] = array[i] - 3;
            } else {
                result[i] = -2;
            }
        }
        return result;
    }
}

