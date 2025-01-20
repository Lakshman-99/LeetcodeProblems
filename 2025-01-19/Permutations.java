package practice;

import java.util.*;

public class Permutations {
    public static List<List<Integer>> result;
    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    public static void solve(int[] nums, int ind) {
        if(ind == nums.length - 1) {
            List<Integer> lis = new ArrayList<>();
            for(int num : nums) lis.add(num);
            result.add(lis);
            return;
        }

        for(int i=ind;i<nums.length;i++) {
            swap(nums, ind, i);
            solve(nums, ind+1);
            swap(nums, ind, i);
        }
    }
    public static List<List<Integer>> permute(int[] nums) {
        result = new ArrayList<>();
        solve(nums, 0);
        return result;
    }
    public static void main(String[] args) {
        int[] arr = {1,2,3};
        System.out.println(permute(arr));
    }
}
