//  2441. Largest Positive Integer That Exists With Its Negative
//
//  https://leetcode.com/problems/largest-positive-integer-that-exists-with-its-negative/

import java.util.Arrays;

public class Largest_Positive_Integer_That_Exists_With_Its_Negative {
    public static int findMaxK(int[] nums) {
        int ans = -1;
        Arrays.sort(nums);

        int i=0, j=nums.length-1;
        while(i<j) {
            if(nums[i] > 0) break;
            if(nums[i]*-1 == nums[j]) {
                ans = nums[j];
                break;
            }
            if(nums[i]*-1 < nums[j]) j--;
            else i++;
        }

        return ans;
    }

    public static void main(String[] args) {
        int ans = findMaxK(new int[]{-10,8,6,7,-2,-3});
        System.out.println(ans);
    }
}
