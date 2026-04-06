import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TopKFrequentElements {

    public static int[] topKFrequentElements(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        ArrayList<ArrayList<Integer>> buckets = new ArrayList<>();
        for (int num : nums) map.merge(num, 1, Integer::sum);
        for (int i = 0; i <= nums.length; i++) buckets.add(new ArrayList<>());
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int key = entry.getKey();
            int value = entry.getValue();
            buckets.get(value).add(key);
        }
        int[] result = new int[k];
        int idx = 0;
        for (int i = buckets.size() - 1; i >= 0 && idx < k; i--) {
            for (int num : buckets.get(i)) {
                result[idx++] = num;
                if (idx == k) break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 2, 3, 4, 4, 4, 4};
        int k = 2;
        System.out.printf("Elements: %s, Frequence: %s%n", Arrays.toString(nums), k);
        System.out.printf("Top Frequence: %s", Arrays.toString(topKFrequentElements(nums, k)));
    }

}