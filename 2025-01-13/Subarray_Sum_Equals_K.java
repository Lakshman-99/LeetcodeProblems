// 560. Subarray Sum Equals K

// https://leetcode.com/problems/subarray-sum-equals-k/description

import java.util.HashMap;

public class Subarray_Sum_Equals_K {
    public static int subarraySum(int[] nums, int k) {
        int ans = 0, sum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            sum += num;

            if (sum == k)
                ans++;

            if (map.containsKey(sum - k))
                ans += map.get(sum - k);

            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return ans;
    }
    public static void main(String[] args) {
        int[] arr = {0,0,0,0,0,0,0,0,0,0};
        System.out.println(subarraySum(arr, 0));
    }
}
