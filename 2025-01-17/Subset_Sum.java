// https://www.geeksforgeeks.org/problems/subset-sums2234/1

import java.util.ArrayList;

public class Subset_Sum {
    public static void solve(int[] arr, ArrayList<Integer> ans, int n, int sum) {
        if(n < 0) return;

        ans.add(sum + arr[n]);
        solve(arr, ans, n-1, sum);
        solve(arr, ans, n-1, sum + arr[n]);

    }
    public static ArrayList<Integer> subsetSums(int[] arr) {
        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(0);
        solve(arr, ans, arr.length - 1, 0);

        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3};
        System.out.println(subsetSums(arr));
    }
}
