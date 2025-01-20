package practice;

import java.util.*;

public class Permutations_II {
    public static List<List<Integer>> result;
    public static void solve(int[] nums, List<Integer> cur, boolean[] used) {
        if(cur.size() == nums.length) {
            result.add(new ArrayList<>(cur));
        }
        else if(cur.size() < nums.length) {
            for(int i=0;i<nums.length;i++) {
                if(used[i] || (i>0 && nums[i] == nums[i-1] && !used[i-1])) continue;
                cur.add(nums[i]);
                used[i] = true;
                solve(nums, cur, used);
                used[i] = false;
                cur.remove(cur.size()-1);
            }
        }
    }
    public static List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        result = new ArrayList<>();
        solve(nums, new ArrayList<>(), new boolean[nums.length]);
        return result;
    }
    public static void main(String[] args) {
        int[] arr = {0,1,0,0,9};
        System.out.println(permuteUnique(arr));
    }
}
