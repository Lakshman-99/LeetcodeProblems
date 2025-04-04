package amazon;

import java.util.*;

public class Top_K_Frequent_Elements {
    public static int[] topKFrequent(int[] nums, int k) {
        if(nums.length == 0) return new int[]{};

        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        List<Integer>[] freq = new ArrayList[nums.length+1];
        for(int i=0;i<freq.length;i++) {
            freq[i] = new ArrayList<>();
        }

        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            freq[entry.getValue()].add(entry.getKey());
        }

        int[] result = new int[k];
        int idx = 0;
        for(int i=freq.length-1;i>=0;i--) {
            for(int num : freq[i]) {
                result[idx++] = num;
                if(idx == k) {
                    return result;
                }
            }
        }

        return result;
    }
    public static void main(String[] args) {
        int[] arr = {1,1,1,2,2,3};
        System.out.println(Arrays.toString(topKFrequent(arr, 2)));
    }
}
