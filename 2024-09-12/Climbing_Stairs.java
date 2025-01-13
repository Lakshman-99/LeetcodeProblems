// 70. Climbing Stairs
//
// https://leetcode.com/problems/climbing-stairs/description/

import java.util.Arrays;

public class Climbing_Stairs {
    public static int solve(int n, int[] dp){
        if(n <= 1) return 1;
        if(dp[n] != -1) return dp[n];
        return dp[n] = solve(n-1, dp) + solve(n - 2, dp);
    }
    public static void main(String[] args) {
        int n=4;
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        System.out.println(solve(n, dp));
    }
}
