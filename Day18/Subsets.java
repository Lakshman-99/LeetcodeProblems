//  78. Subsets
//
//  https://leetcode.com/problems/subsets/description

import java.util.*;

public class Subsets {
    public static List<List<Integer>> ans;
    public static void solve(int[] nums, int ind, List<Integer> store) {
        if(ind == nums.length) {
            ans.add(new ArrayList<>(store));
            return;
        }
        store.add(nums[ind]);
        solve(nums, ind+1, store);
        store.remove(store.size()-1);
        solve(nums, ind+1, store);
    }
    public static List<List<Integer>> subsets(int[] nums) {
        ans = new ArrayList<>();
        solve(nums, 0, new ArrayList<>());
        return ans;
    }

    public static void main(String[] args) {
        List<List<Integer>> resp = subsets(new int[]{1,2,3});
        System.out.println(resp.toString());
    }
}
