package practice;

import java.util.ArrayList;
import java.util.List;

public class Combination_Sum {
    public static List<List<Integer>> result;
    public static void solve(int[] nums, int tar, List<Integer> cur, int n, int ind) {
        if(tar == 0) {
            result.add(new ArrayList<>(cur));
            return;
        }
        if(tar < 0 || ind > n) return;

        cur.add(nums[ind]);
        solve(nums, tar - nums[ind], cur, n, ind);
        cur.remove(cur.size() - 1);
        solve(nums, tar, cur, n, ind+1);

    }
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<>();

        solve(candidates, target, new ArrayList<>(), candidates.length - 1, 0);

        return result;
    }
    public static void main(String[] args) {
        int[] arr = new int[]{2,3,5};
        System.out.println(combinationSum(arr, 8));
    }
}
