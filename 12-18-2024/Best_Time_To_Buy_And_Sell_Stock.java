package practice;

import java.util.Arrays;

public class Best_Time_To_Buy_And_Sell_Stock {
    public static int maxProfit(int[] prices) {
        int max_profit = 0;
        int price = Integer.MAX_VALUE;

        for (int j : prices) {
            if (j < price)
                price = j;
            else if (j - price > max_profit)
                max_profit = j - price;
        }

        return max_profit;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{7,1,5,3,6,4};

        System.out.println(maxProfit(arr));
    }
}
