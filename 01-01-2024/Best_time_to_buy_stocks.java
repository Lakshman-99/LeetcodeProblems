import java.util.*;
public class Best_time_to_buy_stocks {

    public static int maxProfit(int[] prices) {
        int lsf = Integer.MAX_VALUE;
        int op = 0;
        int pist = 0;

        for (int price : prices) {
            if (price < lsf) {
                lsf = price;
            }
            pist = price - lsf;
            if (op < pist) {
                op = pist;
            }
        }
        return op;
    }

    public static void main(String[] args) {
        int profit = maxProfit(new int[]{3,2,6,5,0,3});
        System.out.println(profit);
    }
}
