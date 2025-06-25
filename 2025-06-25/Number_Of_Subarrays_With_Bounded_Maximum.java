package patterns.two_pointers;

public class Number_Of_Subarrays_With_Bounded_Maximum {
    public static int helper(int[] nums, int right) {
        int ans = 0, c = 0;
        for(int num : nums) {
            c = num <= right ? c + 1 : 0;
            ans += c;
        }

        return ans;
    }
    public static int numSubarrayBoundedMax(int[] nums, int left, int right) {
        return helper(nums, right) - helper(nums, left-1);
    }
    public static void main(String[] args) {
        int[] arr = {2,9,2,5,6};
        System.out.println(numSubarrayBoundedMax(arr, 2,8));
    }
}
