package practice;

import java.util.*;

public class Combination_Sum_II {
    public static List<List<Integer>> result;
    public static void solve(int[] nums, int tar, List<Integer> cur, int ind) {
        if(tar == 0) {
            result.add(new ArrayList<>(cur));
            return;
        }

        for (int i = ind; i < nums.length; i++) {
            if(tar - nums[i] < 0) break;
            if (i > ind && nums[i] == nums[i - 1]) continue;

            cur.add(nums[i]);
            solve(nums, tar - nums[i], cur, i + 1);
            cur.remove(cur.size() - 1);
        }
    }
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        result = new ArrayList<>();
        Arrays.sort(candidates);
        solve(candidates, target, new ArrayList<>(), 0);

        return result;
    }
    public static void main(String[] args) {
        int[] arr = {10, 1,2,7,6,1,5};
        System.out.println(combinationSum2(arr, 8));
    }
}
