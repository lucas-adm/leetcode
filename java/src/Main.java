import codes.c226.TreeNode;

import java.util.*;

import static codes.c1.TwoSum.twoSum;
import static codes.c125.IsPalindrome.isPalindrome;
import static codes.c128.LongestConsecutiveSequence.longestConsecutive;
import static codes.c226.InvertBinaryTree.invertTree;
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

    private static String treeToString(TreeNode root) {
        if (root == null) return "[]";
        List<String> values = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == null) values.add("null");
            else {
                values.add(String.valueOf(node.val));
                queue.add(node.left);
                queue.add(node.right);
            }
        }
        int last = values.size() - 1;
        while (last >= 0 && values.get(last).equals("null")) values.remove(last--);
        return values.toString();
    }

    private static final TreeNode TO_INVERT = new TreeNode(4,
            new TreeNode(2, new TreeNode(1), new TreeNode(3)),
            new TreeNode(7, new TreeNode(6), new TreeNode(9)));
    private static final int[] TO_SORT = {7, 5, 3, 1};
    private static final String TO_P1 = "arara";
    private static final String TO_P2 = "arare";
    private static final String TO_ROL = "a1b-c2d-e3f";
    private static final int[] TO_LCS = {11, 77, 12, 24, 144, 13, 32, 72, 14, 48, 15, 666};
    private static final int[] TO_TKFE = {1, 1, 1, 1, 2, 2, 3, 3, 3, 4, 4, 4, 4, 4};
    private static final int[] TO_TS = {2, 7, 11, 15};

    public static void main(String[] args) {
        line();
        showString("Before inv", treeToString(TO_INVERT));
        invertTree(TO_INVERT);
        showString("After inv", treeToString(TO_INVERT));
        line();
        showArray("Before bs", TO_SORT);
        bubbleSort(TO_SORT);
        showArray("After bs", TO_SORT);
        line();
        System.out.printf("%-12s: %s -> %s%n", "Palindrome", TO_P1, isPalindrome(TO_P1));
        System.out.printf("%-12s: %s -> %s%n", "Palindrome", TO_P2, isPalindrome(TO_P2));
        line();
        showString("Before rol", TO_ROL);
        showString("After rol", reverseOnlyLetters(TO_ROL));
        line();
        showArray("Input lcs", TO_LCS);
        System.out.printf("%-12s: %d%n", "LCS result", longestConsecutive(TO_LCS));
        line();
        showArray("Input tkfe", TO_TKFE);
        System.out.printf("%-12s: %s%n", "Top 2", Arrays.toString(topKFrequentElements(TO_TKFE, 2)));
        line();
        showArray("Input ts", TO_TS);
        System.out.printf("%-12s: %d%n", "Target", 9);
        try {
            int[] result = twoSum(TO_TS, 9);
            System.out.printf("%-12s: %s%n", "TwoSum", Arrays.toString(result));
        } catch (IllegalArgumentException e) {
            System.out.printf("%-12s: %s%n", "TwoSum", e.getMessage());
        }
        line();
    }

}