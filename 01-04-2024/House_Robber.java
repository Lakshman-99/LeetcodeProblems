import java.util.Arrays;

public class House_Robber {
    public static int maxLoot(int n, int[] nums, int[] dp) {
        if(n==0) {
            return nums[n];
        }
        if(n<0) {
            return 0;
        }
        if(dp[n] != -1) {
            return dp[n];
        }
        return dp[n] = Math.max(maxLoot(n-2, nums, dp) + nums[n], maxLoot(n-1, nums, dp));
    }

    public static int rob(int[] nums) {
        int n = nums.length;
//        int[] dp = new int[n];
//        Arrays.fill(dp, -1);
//        if(n<=1) {
//            return nums[n-1];
//        }
//        return maxLoot(n-1, nums, dp);
//        dp[0] = nums[0];
//        for(int i=1;i<n;i++) {
//            int temp = nums[i];
//            if(i-2>=0) {
//                temp+=dp[i-2];
//            }
//            dp[i] = Math.max(temp, dp[i-1]);
//        }
//        return dp[n-1];
        int pre = nums[0];
        int pre2 = 0;
        for(int i=1; i<n;i++) {
            int cur = Math.max(nums[i]+pre2, pre);
            pre2 = pre;
            pre = cur;
        }
        return pre;
    }

    public static void main(String[] args) {
        int ans = rob(new int[]{2,7,9,3,1});
        System.out.println(ans);
    }
}
