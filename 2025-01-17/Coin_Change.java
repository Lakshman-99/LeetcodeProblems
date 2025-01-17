package practice;

import java.util.Arrays;

public class Coin_Change {
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
        System.out.println(coinChange(coin, 6249));
    }
}
