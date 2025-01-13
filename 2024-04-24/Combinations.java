//  77. Combinations
//
//  https://leetcode.com/problems/combinations/description/

import java.util.*;
public class Combinations {
    public static List<List<Integer>> ans;
    public static void solve(int ind, int count, int n, int k, List<Integer> store) {
        if(count == k) {
            ans.add(new ArrayList<>(store));
            return;
        }

        for(int j=ind;j<=n;j++) {
            store.add(j);
            solve(j+1, count+1, n, k, store);
            store.remove(store.size()-1);
        }
    }
    public static List<List<Integer>> combine(int n, int k) {
        ans = new ArrayList<>();
        solve(1, 0, n, k, new ArrayList<>());
        return ans;
    }
    public static void main(String[] args) {
        List<List<Integer>> ans = combine(4, 2);
        for(List<Integer> i : ans)
            System.out.println(i.toString());
    }
}
