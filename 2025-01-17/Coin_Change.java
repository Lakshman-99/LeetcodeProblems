package practice;

import java.util.Arrays;

public class Coin_Change {
    public static int solve(int[] coins, int[] dp, int amount) {
        if(amount == 0) {
            return 0;
        }

        if(amount < 0) {
            return Integer.MAX_VALUE;
        }

        if(dp[amount] != -1) {
            return dp[amount];
        }

        int min = Integer.MAX_VALUE;
        for (int coin : coins) {
            int ans = solve(coins, dp, amount - coin);
            if (ans != Integer.MAX_VALUE)
                min = Math.min(min, 1 + ans);
        }

        return dp[amount] = min;
    }
    public static int coinchange2(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        Arrays.fill(dp, -1);

        int ans = solve(coins, dp, amount);
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    public static int coinChange(int[] coins, int amount) {
        int min = 0;
        Arrays.sort(coins);

        for(int i=coins.length-1;i>=0;i--) {
            int coin = coins[i];

            while(amount - coin >= 0) {
                amount -= coin;
                min++;
            }
        }

        return amount != 0 ? -1 : min;
    }
    public static void main(String[] args) {
        int[] coin = new int[]{186,419,83,408};
        System.out.println(coinchange2(coin, 6249));
    }
}
