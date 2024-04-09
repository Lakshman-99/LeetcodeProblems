//  2073. Time Needed to Buy Tickets
//
//  https://leetcode.com/problems/time-needed-to-buy-tickets/description/

public class Time_Needed_To_Buy_Tickets {
    public static int timeRequiredToBuy(int[] tickets, int k) {
        int ans = 0, ind = 0;
        int p = tickets[k];

        for(int t : tickets) {
            if(ind++ > k) ans += Math.min(t, p-1);
            else ans += Math.min(t, p);
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] arr = new int[]{84,49,5,24,70,77,87,8};
        int k = 3;
        System.out.print(timeRequiredToBuy(arr, k));
    }
}
