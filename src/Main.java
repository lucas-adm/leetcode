import java.util.Arrays;

import static codes.c1.TwoSum.twoSum;
import static codes.c125.IsPalindrome.isPalindrome;
import static codes.c128.LongestConsecutiveSequence.longestConsecutive;
import static codes.c347.TopKFrequentElements.topKFrequentElements;
import static codes.c917.ReverseOnlyLetters.reverseOnlyLetters;
import static codes.none.BubbleSort.bubbleSort;

public class Main {

    private static void line() {
        System.out.println("=".repeat(40));
    }

    private static void showArray(String label, int[] arr) {
        System.out.printf("%-12s: %s%n", label, Arrays.toString(arr));
    }

    private static void showString(String label, String value) {
        System.out.printf("%-12s: %s%n", label, value);
    }

    public static void main(String[] args) {
        int[] toSort = {7, 5, 3, 1};
        String toP1 = "arara";
        String toP2 = "arare";
        String toRol = "a1b-c2d-e3f";
        int[] toLcs = {11, 77, 12, 24, 144, 13, 32, 72, 14, 48, 15, 666};
        int[] toTkfe = {1, 1, 1, 1, 2, 2, 3, 3, 3, 4, 4, 4, 4, 4};
        int[] toTs = {2, 7, 11, 15};
        line();
        showArray("Before bs", toSort);
        bubbleSort(toSort);
        showArray("After bs", toSort);
        line();
        System.out.printf("%-12s: %s -> %s%n", "Palindrome", toP1, isPalindrome(toP1));
        System.out.printf("%-12s: %s -> %s%n", "Palindrome", toP2, isPalindrome(toP2));
        line();
        showString("Before rol", toRol);
        showString("After rol", reverseOnlyLetters(toRol));
        line();
        showArray("Input lcs", toLcs);
        System.out.printf("%-12s: %d%n", "LCS result", longestConsecutive(toLcs));
        line();
        showArray("Input tkfe", toTkfe);
        System.out.printf("%-12s: %s%n", "Top 2", Arrays.toString(topKFrequentElements(toTkfe, 2)));
        line();
        showArray("Input ts", toTs);
        System.out.printf("%-12s: %d%n", "Target", 9);
        try {
            int[] result = twoSum(toTs, 9);
            System.out.printf("%-12s: %s%n", "TwoSum", Arrays.toString(result));
        } catch (IllegalArgumentException e) {
            System.out.printf("%-12s: %s%n", "TwoSum", e.getMessage());
        }
        line();
    }

}