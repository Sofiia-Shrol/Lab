package Lab5;

public class Sorting {
    // Bubble Sort
    public static void bubbleSort(double[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    // Обмін місцями
                    double temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    // Selection Sort
    public static void selectionSort(double[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            // Обмін місцями
            double temp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = temp;
        }
    }

    public static void main(String[] args) {
        double[] array = {64.5, 34.2, 25.6, 12.4, 22.3, 11.1, 90.8};

        System.out.println("Оригінальний масив:");
        for (double num : array) {
            System.out.print(num + " ");
        }

        // Bubble Sort
        bubbleSort(array);
        System.out.println("\n\nВідсортовано Bubble Sort:");
        for (double num : array) {
            System.out.print(num + " ");
        }

        // Відновлення масиву для другого сортування
        double[] array2 = {64.5, 34.2, 25.6, 12.4, 22.3, 11.1, 90.8};

        // Selection Sort
        selectionSort(array2);
        System.out.println("\n\nВідсортовано Selection Sort:");
        for (double num : array2) {
            System.out.print(num + " ");
        }
    }
}
