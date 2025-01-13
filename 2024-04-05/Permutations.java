//  46. Permutations
//
//  https://leetcode.com/problems/permutations/description/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutations {
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static void solve(int ind, int[] nums, List<List<Integer>> ans) {
        if(ind == nums.length) {
            List<Integer> perm = new ArrayList<>();
            for(int num : nums) perm.add(num);
            ans.add(perm);
            return;
        }
        for(int i=ind;i<nums.length;i++) {
            swap(nums, ind, i);
            solve(ind+1, nums, ans);
            swap(nums, ind, i);
        }
    }
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        solve(0, nums, ans);
        return ans;
    }
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3};
        List<List<Integer>> ans = permute(arr);
        System.out.println(Arrays.toString(ans.toArray()));
    }
}
