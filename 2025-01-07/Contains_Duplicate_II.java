// 219. Contains Duplicate II

// https://leetcode.com/problems/contains-duplicate-ii/description

import java.util.HashMap;

public class Contains_Duplicate_II {
    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i=0;i<nums.length;i++) {
            if(map.containsKey(nums[i]) && Math.abs(map.get(nums[i]) - i) <= k) {
                return true;
            }
            map.put(nums[i], i);
        }
        return false;
    }
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,1};
        System.out.println(containsNearbyDuplicate(arr, 3));
    }
}
