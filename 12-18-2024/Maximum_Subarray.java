package practice;

public class Maximum_Subarray {
    public static int maxSubArray(int[] nums) {
        int maxSum = Integer.MIN_VALUE, curSum = 0;

        for (int num : nums) {
            curSum += num;
            maxSum = Math.max(curSum, maxSum);
            curSum = Math.max(curSum, 0);
        }

         return maxSum;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{-1};
        System.out.println(maxSubArray(arr));
    }
}
