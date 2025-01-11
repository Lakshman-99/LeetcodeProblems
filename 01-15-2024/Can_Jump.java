import java.util.*;
public class Can_Jump {
    public static boolean jump(int n, int[] nums, int[] dp) {
        if(n == nums.length-1) {
            return true;
        }
        if(n >= nums.length) {
            return false;
        }
        if(dp[n] != -1) {
            return dp[n] == 1;
        }
        boolean canJump = false;
        for(int i=1;i<=nums[n];i++) {
            canJump = jump(n+i, nums, dp);
            if(canJump) {
                break;
            }
        }
        dp[n] = canJump ? 1 : 0;
        return canJump;
    }
    public static boolean canJump(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
//        return jump(0, nums, dp);

        dp[0] = 1;
        for(int i=0;i<n;i++) {
            if(dp[i] == 1) {
                for (int j = 1; j <= nums[i]; j++) {
                    if (i + j < n) {
                        dp[i + j] = 1;
                    }
                }
            }
        }
        return dp[n-1] == 1;
    }
    public static void main(String[] args) {
        boolean ans = canJump(new int[]{1,4,0,3,4});
        System.out.println(ans);
    }
}
