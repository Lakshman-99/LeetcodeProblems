package patterns.sliding_window;

public class Longest_Subarray_Of_1s_After_Deleting_One_Element {
    public static int longestSubarray(int[] nums) {
        int result = 0, left = 0, curOne = 0;

        for(int right=0;right<nums.length;right++) {
            if(nums[right] == 0) {
                curOne++;
            }
            if(curOne > 1) {
                while(nums[left] != 0) {
                    left++;
                }
                left++;
                curOne--;
            }
            result = Math.max(result, right - left - curOne + 1);
        }

        return curOne == 0 ? result - 1 : result;
    }
    public static void main(String[] args) {
        int[] arr = {0,1,1,1,0,1,1,0,1,1,1,1,1,1,1,1,1,1,1,1,1};
        System.out.println(longestSubarray(arr));
    }
}
