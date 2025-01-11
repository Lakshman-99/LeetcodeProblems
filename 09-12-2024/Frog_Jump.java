import java.util.*;

public class Frog_Jump {
    public static int min(int[] arr, int n, int[] dp) {
        if(n == 0) return 0;
        if(dp[n] != -1) return dp[n];
        int one = min(arr, n-1, dp) + Math.abs(arr[n] - arr[n-1]);
        int two = Integer.MAX_VALUE;
        if(n>1) {
            two = min(arr, n - 2, dp) + Math.abs(arr[n] - arr[n-2]);
        }

        return dp[n] = Math.min(one , two);
    }
    public static void main(String[] args) {
        int[] dp = new int[4];
        int[] arr = new int[]{10,20,30,10};
        Arrays.fill(dp, -1);
        System.out.println(min(arr, 3, dp));
    }
}