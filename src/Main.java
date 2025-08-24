import java.lang.reflect.Array;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        int[] nums = {1, 2, 2, 3, 3, 3};
        int k = 2;

        int [] result = topKFrequent(nums, k);
        System.out.println(Arrays.toString(result));
    }

    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> memory = new HashMap<>();

        for (int num : nums) {
            memory.put(num, memory.getOrDefault(num, 0) + 1);
        }

        // Min-heap to keep top k by frequency
        PriorityQueue<Map.Entry<Integer, Integer>> heap = new PriorityQueue<>(
                (a, b) -> a.getValue() - b.getValue()
        );

        for (Map.Entry<Integer, Integer> entry : memory.entrySet()) {
            heap.offer(entry);
            if (heap.size() > k) {
                heap.poll(); // remove smallest frequency
            }
        }

        // Extract results
        int[] result = new int[k];
        for (int i = k - 1; i >= 0; i--) {
            result[i] = heap.poll().getKey();
        }

        return result;

    }
}
