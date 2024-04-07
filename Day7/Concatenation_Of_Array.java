//  1929. Concatenation of Array
//
//  https://leetcode.com/problems/concatenation-of-array/description/

import java.util.Arrays;

public class Concatenation_Of_Array {
    public static int[] getConcatenation(int[] nums) {
        int n = nums.length;
        int[] ans = new int[2*n];
        for(int i=0;i<2*n;i++) {
            ans[i] = nums[i%n];
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] arr = new int[]{1,3,2,1};
        int[] ans = getConcatenation(arr);
        System.out.println(Arrays.toString(ans));
    }

}
