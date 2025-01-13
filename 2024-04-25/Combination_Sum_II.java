//  40. Combination Sum II
//
//  https://leetcode.com/problems/combination-sum-ii/description/

import java.util.*;

public class Combination_Sum_II {
    public static Set<List<Integer>> ans;
    public static void solve(int[] candidates, int ind, int target, List<Integer> store) {
        if(target == 0) {
            ans.add(new ArrayList<>(store));
            return;
        }
        for(int i=ind;i<candidates.length;i++) {
            if(i > ind && candidates[i] == candidates[i-1]) continue;
            if(target - candidates[i] >= 0) {
                store.add(candidates[i]);
                solve(candidates, i+1, target - candidates[i], store);
                store.remove(store.size()-1);
            }
        }
    }
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        ans = new HashSet<>();
        Arrays.sort(candidates);
        solve(candidates, 0, target, new ArrayList<>());
        return new ArrayList<>(ans);
    }
    public static void main(String[] args) {
        List<List<Integer>> ans = combinationSum2(new int[]{10,1,2,7,6,1,5}, 8);
        for(List<Integer> i : ans)
            System.out.println(i.toString());
    }
}
