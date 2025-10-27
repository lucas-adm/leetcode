import java.util.Arrays;

public class BubbleSort {

    private static void bubbleSort(int[] numbers) {
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

    public static void main(String[] args) {
        int[] numbers = {11, 666, 33, 7, 10, 48, 24, 12, 72, 22};
        System.out.println("Unordered list: " + Arrays.toString(numbers));
        bubbleSort(numbers);
        System.out.println("Ordered list: " + Arrays.toString(numbers));
    }

}