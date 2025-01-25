import java.util.*;

public class Top_K_Frequent_Elements {
    public static int[] topKFrequent(int[] nums, int k) {
        int[] ans = new int[k];

        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num : nums) map.put(num, map.getOrDefault(num, 0) + 1);

        PriorityQueue<Map.Entry<Integer, Integer>> heap = new PriorityQueue<>(Comparator.comparingInt(Map.Entry::getValue));
        for(Map.Entry<Integer, Integer> hash : map.entrySet()) {
            heap.offer(hash);
            if(heap.size() > k)
                heap.poll();
        }

        for(int i=k-1;i>=0;i--)
            ans[i] = heap.poll().getKey();

        return ans;
    }
    public static void main(String[] args) {
        int[] arr = {1};
        System.out.println(Arrays.toString(topKFrequent(arr, 1)));
    }
}
