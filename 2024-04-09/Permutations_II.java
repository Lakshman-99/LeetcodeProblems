//  47. Permutations II
//
//  https://leetcode.com/problems/permutations-ii/description/

import java.util.*;

public class Permutations_II {
    public static Set<List<Integer>> set;
    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    public static void solve(int[] nums, int ind, int n) {
        if(ind == n) {
            List<Integer> soln = new ArrayList<>();
            for(int num : nums) soln.add(num);
            set.add(soln);
            return;
        }
        for(int i=ind;i<n;i++) {
            swap(nums, ind, i);
            solve(nums, ind+1, n);
            swap(nums, ind, i);
        }
    }
    public static List<List<Integer>> permuteUnique(int[] nums) {
        set = new HashSet<>();
        int n = nums.length;
        solve(nums, 0, n);
        return new ArrayList<>(set);
    }
    public static void main(String[] args) {
        List<List<Integer>> ans = permuteUnique(new int[]{1,1,2});
        System.out.print(Arrays.toString(ans.toArray()));
    }
}
