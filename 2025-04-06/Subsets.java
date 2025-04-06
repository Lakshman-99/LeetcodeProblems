package amazon;

import java.util.*;

public class Subsets {
    public static void solve(int[] nums, int cur, List<Integer> curList, List<List<Integer>> result) {
        if(cur == nums.length) {
            result.add(new ArrayList<>(curList));
            return;
        }

        curList.add(nums[cur]);
        solve(nums, cur+1, curList, result);
        curList.remove(curList.size()-1);
        solve(nums, cur+1, curList, result);
    }
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        solve(nums, 0, new ArrayList<>(), result);
        return result;
    }
    public static void main(String[] args) {
        int[] arr = {1,2,3};
        System.out.println(subsets(arr));
    }
}
