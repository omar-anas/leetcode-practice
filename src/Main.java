import sun.nio.cs.CharsetMapping;

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

        PriorityQueue <Map.Entry<Integer,Integer>> heap = new PriorityQueue<>((a, b) -> Integer.compare(b.getValue(), a.getValue()));

        for(Map.Entry<Integer , Integer> entry : memory.entrySet()){
            heap.add(entry);
        }

        List <Integer> s = new ArrayList();
        while(k> 0){
            s.add(heap.poll().getKey());
            k--;
        }


        int[] o = s.stream().mapToInt(i -> i).toArray();

        System.out.println(Arrays.toString(o));
        return o;
    }
}
