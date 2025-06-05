package patterns.sliding_window;

public class Minimum_Size_Subarray_Sum {
    public static int minSubArrayLen(int target, int[] nums) {
        int left = 0, sum = 0, result = Integer.MAX_VALUE;
        for(int right=0;right<nums.length;right++) {
            sum += nums[right];
            while(sum >= target) {
                result = Math.min(result, right - left + 1);
                sum -= nums[left++];
            }
        }

        return result == Integer.MAX_VALUE ? 0 : result;
    }
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        System.out.println(minSubArrayLen(15, arr));
    }
}
