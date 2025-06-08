package patterns.sliding_window;

import java.util.HashMap;
import java.util.HashSet;

public class Subarrays_With_K_Different_Integers {
    public static int helper(int[] nums, int k) {
        if(nums == null || nums.length < k) {
            return 0;
        }
        if(k == 1) {
            return nums.length;
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        int left = 0, answer = 0;
        for(int right=0;right<nums.length;right++) {
            map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);
            while(map.size() > k && left <= right) {
                map.put(nums[left], map.get(nums[left]) - 1);
                if (map.get(nums[left]) == 0)
                    map.remove(nums[left]);

                left++;
            }

            answer += right-left+1;
        }

        return answer;
    }
    public static int subarraysWithKDistinct(int[] arr, int k) {
        return helper(arr, k) - helper(arr, k-1);
    }
    public static void main(String[] args) {
        int[] arr = {1,2,1,2,3};
        System.out.println(subarraysWithKDistinct(arr, 2));
    }
}
