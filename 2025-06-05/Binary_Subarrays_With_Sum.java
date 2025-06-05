package patterns.sliding_window;

public class Binary_Subarrays_With_Sum {
    public static int numSubarraysWithSum(int[] nums, int goal) {
        int result = 0, sum = 0, left = 0;
        for(int right=0;right<nums.length;right++) {
            sum += nums[right];
            while(left <= right && sum > goal) {
                sum -= nums[left++];
            }
            result += right - left + 1;
        }

        return result;
    }
    public static void main(String[] args) {
        int[] arr = {0,0,0,0,0};
        System.out.println(numSubarraysWithSum(arr, -1));
    }
}
