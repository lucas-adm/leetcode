import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TopKFrequentElements {

    public static int[] topKFrequentElements(int[] nums, int k) {

        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int num : nums) freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);

        List<Integer>[] buckets = new ArrayList[nums.length + 1];
        for (int i = 0; i < buckets.length; i++) buckets[i] = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) buckets[entry.getValue()].add(entry.getKey());

        List<Integer> resultList = new ArrayList<>();
        for (int i = buckets.length - 1; i >= 0 && resultList.size() < k; i--) if (!buckets[i].isEmpty()) resultList.addAll(buckets[i]);

        int[] result = new int[k];
        for (int i = 0; i < k; i++) result[i] = resultList.get(i);
        return result;

    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 2, 3, 4, 4, 4, 4};
        int k = 2;
        int[] result = topKFrequentElements(nums, k);
        System.out.print("[");
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i]);
            if (i < result.length - 1) System.out.print(", ");
        }
        System.out.print("]");
    }

}