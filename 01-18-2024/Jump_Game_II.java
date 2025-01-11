import java.util.*;
public class Jump_Game_II {
    public static int solve(int n, int[] nums, int[] dp) {
        if(n >= nums.length) {
            return Integer.MAX_VALUE;
        }
        if(n == nums.length-1) {
            return 0;
        }
        if(dp[n] != -1) {
            return dp[n];
        }
        int min = Integer.MAX_VALUE-10;
        for(int i=1;i<=nums[n];i++) {
            min = Math.min(min, solve(n+i, nums, dp));
        }
        return dp[n] = min + 1;
    }
    public static int jump(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);

        return solve(0, nums, dp);
    }
    public static void main(String[] args) {
        int ans = jump(new int[]{2,3,0,1,4});
        System.out.println(ans);
    }
}
