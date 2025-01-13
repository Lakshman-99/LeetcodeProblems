public class P_Maximum_Subarray {
    public static int maxSubArray(int[] nums) {
        int sum = 0, max = nums[0];

        for(int num : nums) {
            sum+=num;
            max = Math.max(max, sum);
            if(sum < 0) {
                sum = 0;
            }
        }
        return max;
    }
    public static void main(String[] args) {
        int[] num = new int[]{-2,-1};
        System.out.println(maxSubArray(num));
    }
}
