package amazon;

import java.util.*;
import java.util.stream.Collectors;

public class Permutation {
    public static void swap(int[] nums, int s, int e) {
        int temp = nums[s];
        nums[s] = nums[e];
        nums[e] = temp;
    }
    public static void solve(int[] nums, int cur, List<List<Integer>> ans) {
        if(cur == nums.length) {
            List<Integer> curList = new ArrayList<>();
            for(int num : nums)
                curList.add(num);
            ans.add(curList);
            return;
        }

        for(int i=cur;i<nums.length;i++) {
            swap(nums, cur, i);
            solve(nums, cur+1, ans);
            swap(nums, cur, i);
        }
    }
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        solve(nums, 0, result);
        return  result;
    }
    public static void main(String[] args) {
        int[] arr = {1,2,3};
        System.out.println(permute(arr));
    }
}
