//  39. Combination Sum
//
//  https://leetcode.com/problems/combination-sum/description/

import java.util.*;
public class Combination_Sum {
    public static List<List<Integer>> ans;
    public static void solve(int[] candidates, int target, int ind, List<Integer> store) {
        if(target == 0) {
            ans.add(new ArrayList<>(store));
            return;
        }
        for(int j=ind;j<candidates.length;j++) {
            if(target - candidates[j] >= 0) {
                store.add(candidates[j]);
                solve(candidates, target - candidates[j], j, store);
                store.remove(store.size() - 1);
            }
        }
    }
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        ans = new ArrayList<>();
        solve(candidates, target, 0, new ArrayList<>());
        return ans;
    }
    public static void main(String[] args) {
        List<List<Integer>> ans = combinationSum(new int[]{2,3,6,7}, 7);
        for(List<Integer> i : ans)
            System.out.println(i.toString());
    }
}
