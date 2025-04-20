import java.util.Arrays;

public class Find_X_Value_Of_Array_I {
    public static long[] resultArray(int[] nums, int k) {
        long[] result = new long[k];
        long[] dp = new long[k];

        for (int num : nums) {
            int m = num % k;
            long[] newDp = new long[k];

            newDp[m]++;
            for (int r = 0; r < k; r++) {
                if (dp[r] != 0) {
                    int nr = (int)(((long) r * m) % k);
                    newDp[nr] += dp[r];
                }
            }

            for (int r = 0; r < k; r++) {
                result[r] += newDp[r];
            }

            dp = newDp;
        }

        return result;
    }
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5};
        System.out.println(Arrays.toString(resultArray(nums, 3)));
    }
}
