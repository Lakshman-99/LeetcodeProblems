import java.util.Arrays;

public class Maximum_Number_Of_Operation_With_Same_Score_II {

    public static int solve(int[] nums, int[] dp, int i, int j) {
        if(i < 0 || j < 0) {
            return 0;
        }
        // if(sum == )

        return 0;
    }
    public static int maxOperations(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);

        if(n==1) return nums[0];

        return solve(nums, dp, n-1, n-2);
    }

    public static void main(String[] args) {
        int ans = maxOperations(new int[]{3,2,1,2,3,4});
        System.out.println(ans);
    }
}
