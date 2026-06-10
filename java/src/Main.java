import java.util.*;

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

    private static void bs(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n - 1; i++) {
            boolean hasChanged = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j + 1];
                    nums[j + 1] = nums[j];
                    nums[j] = temp;
                    hasChanged = true;
                }
            }
            if (!hasChanged) break;
        }
    }

    private static int[] ts(int target, int[] n) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n.length; i++) {
            int complement = target - n[i];
            if (map.containsValue(complement)) return new int[]{complement, n[i]};
            map.put(i, n[i]);
        }
        throw new IllegalArgumentException("fazueli");
    }

    private static String rv(String s) {
        char[] c = s.toCharArray();
        int l = 0;
        int r = c.length - 1;
        while (l < r) {
            if (!Character.isAlphabetic(c[l])) l++;
            else if (!Character.isAlphabetic(c[r])) r--;
            else {
                char temp = c[r];
                c[r] = c[l];
                c[l] = temp;
                l++;
                r--;
            }
        }
        return new String(c);
    }

    private static boolean isp(String s) {
        int l = 0;
        int r = s.length() - 1;
        while (l < r) {
            char a = s.charAt(l);
            char b = s.charAt(r);
            if (!Character.isLetterOrDigit(a)) l++;
            else if (!Character.isLetterOrDigit(b)) r--;
            else {
                if (a != b) return false;
                l++;
                r--;
            }
        }
        return true;
    }

    private static int lcs(int[] n) {
        HashSet<Integer> set = new HashSet<>();
        int ls = 0;
        for (int num : n) set.add(num);
        for (int num : set) {
            if (set.contains(num - 1)) continue;
            int cs = 1;
            int cn = num;
            while (set.contains(cn + 1)) {
                cs++;
                cn++;
            }
            ls = Math.max(ls, cs);
        }
        return ls;
    }

    private static int[] tkfe(int[] n, int k) {
        int[] results = new int[k];
        HashMap<Integer, Integer> map = new HashMap<>();
        ArrayList<ArrayList<Integer>> buckets = new ArrayList<>();
        for (int num : n) map.merge(num, 1, Integer::sum);
        for (int i = 0; i <= n.length; i++) buckets.add(new ArrayList<>());
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            buckets.get(entry.getValue()).add(entry.getKey());
        }
        int idx = 0;
        for (int i = buckets.size() - 1; i >= 0 && idx < k; i--) {
            for (int num : buckets.get(i)) {
                results[idx++] = num;
                if (idx == k) break;
            }
        }
        return results;
    }

    public static void main(String[] args) {
        int[] toSort = {7, 5, 3, 1};
        String toP1 = "arara";
        String toP2 = "arare";
        String toRol = "a1b-c2d-e3f";
        int[] toLcs = {11, 77, 12, 24, 144, 13, 32, 72, 14, 48, 15, 666};
        int[] toTkfe = {1, 1, 1, 1, 2, 2, 3, 3, 3, 4, 4, 4, 4, 4};
        int toTkfeK = 2;
        int toTarget = 13;
        int[] toTs = {2, 7, 11, 15};
        line();
        showArray("Before bs", toSort);
        bs(toSort);
        showArray("After bs", toSort);
        line();
        System.out.printf("%-12s: %s -> %s%n", "Palindrome", toP1, isp(toP1));
        System.out.printf("%-12s: %s -> %s%n", "Palindrome", toP2, isp(toP2));
        line();
        showString("Before rol", toRol);
        showString("After rol", rv(toRol));
        line();
        showArray("Input lcs", toLcs);
        System.out.printf("%-12s: %d%n", "LCS result", lcs(toLcs));
        line();
        showArray("Input tkfe", toTkfe);
        System.out.printf("%-12s: %s%n", "Top 2", Arrays.toString(tkfe(toTkfe, toTkfeK)));
        line();
        showArray("Input ts", toTs);
        System.out.printf("%-12s: %d%n", "Target", toTarget);
        try {
            int[] result = ts(toTarget, toTs);
            System.out.printf("%-12s: %s%n", "TwoSum", Arrays.toString(result));
        } catch (IllegalArgumentException e) {
            System.out.printf("%-12s: %s%n", "TwoSum", e.getMessage());
        }
        line();
    }

}