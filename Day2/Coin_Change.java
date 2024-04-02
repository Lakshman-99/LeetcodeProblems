//  322. Coin Change
//
//  https://leetcode.com/problems/coin-change/description/


import java.util.Arrays;

public class Coin_Change {
    public static int solve(int[] coins, int[][] dp, int value, int index) {
        if (index < 0) {
            dp[0][value] = 0;
            return Integer.MAX_VALUE;
        }

        if (value < 0) {
            dp[index][0] = 0;
            return Integer.MAX_VALUE;
        }

        if (value == 0) {
            dp[index][value] = 0;
            return 0;
        }

        if (dp[index][value] != -2) {
            return dp[index][value];
        }

        int take = solve(coins, dp, value - coins[index], index);
        int not_take = solve(coins, dp, value, index - 1);

        return dp[index][value] = take < not_take ? 1 + take : not_take;
    }
    public static int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n+1][amount+1];
        for(int[] arr : dp)
            Arrays.fill(arr, -2);

        int result = solve(coins, dp, amount, coins.length - 1);
        return result == Integer.MAX_VALUE ? -1 : result;
    }
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,5};
        int ans = coinChange(arr, 11);
        System.out.println(ans);
    }
}
