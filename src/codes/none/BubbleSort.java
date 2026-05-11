package codes.none;

public class BubbleSort {

    public static void bubbleSort(int[] numbers) {
        int n = numbers.length;
        for (int i = 0; i < n - 1; i++) {
            boolean hasChanged = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (numbers[j] > numbers[j + 1]) {
                    int temp = numbers[j + 1];
                    numbers[j + 1] = numbers[j];
                    numbers[j] = temp;
                    hasChanged = true;
                }
            }
            if (!hasChanged) break;
        }
    }

}