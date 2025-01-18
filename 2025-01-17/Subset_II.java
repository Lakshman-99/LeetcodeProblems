// 90. Subsets II

// https://leetcode.com/problems/subsets-ii/

import java.util.*;

public class Subset_II {
    public static List<List<Integer>> result = new ArrayList<>();
    public static void backtrack(int[] nums, int i, int n, List<Integer> list) {
        result.add(new ArrayList<>(list));

        for(int start = i; start < n; start++) {
            if(start > i && nums[start] == nums[start - 1]) continue;
            list.add(nums[start]);
            backtrack(nums, start + 1, n, list);
            list.remove(list.size() - 1);
        }
    }
    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        backtrack(nums, 0, nums.length, new ArrayList<>());
        return result;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,2};
        System.out.println(subsetsWithDup(arr));
    }
}
