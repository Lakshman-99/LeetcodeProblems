package patterns.sliding_window;

public class Max_Consecutive_Ones_III {
    public static int longestOnes(int[] nums, int k) {
        if(nums.length < k) return nums.length;

        int result = 0, left = 0, skipZeros = 0;
        for(int right=0;right<nums.length;right++) {
            if(nums[right] == 0)
                skipZeros++;

            while(skipZeros > k) {
                if(nums[left] == 0) {
                    skipZeros--;
                }
                left++;
            }
            result = Math.max(result, right - left + 1);
        }

        return result;
    }
    public static void main(String[] args) {
        int[] arr = {0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1};
        System.out.println(longestOnes(arr, 3));
    }
}
