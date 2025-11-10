import java.util.HashMap;

public class TwoSum {

    private static int[] twoSun(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) return new int[]{map.get(complement), i};
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two numbers sum up to the target.");
    }

    public static void main(String[] args) {
        int[] nums = {11, 666, 33, 7, 10, 48, 24, 12, 22};
        int target = 72;
        int[] res = twoSun(nums, target);
        System.out.println("Indexes found: [" + res[0] + ", " + res[1] + "]");
    }

}