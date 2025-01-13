import java.util.*;

public class Buy_two_chocolate {
    public static int buyChoco(int[] prices, int money) {
        if(prices.length < 2) {
            return money;
        }
        Arrays.sort(prices);
        int ans = money - prices[0] - prices[1];
        if(ans < 0) {
            return money;
        }
        return ans;
    }

    public static void main(String[] args) {
        int leftOver = buyChoco(new int[]{1,2,2}, 3);

        System.out.println(leftOver);
    }
}
