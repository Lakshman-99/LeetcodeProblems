package patterns.two_pointers;

import java.util.Arrays;

public class Squares_Of_A_Sorted_Array {
    public static int[] sortedSquares(int[] nums) {
        if(nums == null || nums.length == 0) {
            return new int[]{};
        }

        int n=nums.length;
        int[] result = new int[n];
        int left=0, right=n-1;
        for(int i=n-1; i>=0;i--){
            int square;
            if(Math.abs(nums[left]) < Math.abs(nums[right])) {
                square = nums[right];
                right--;
            } else {
                square = nums[left];
                left++;
            }
            result[i] = square * square;
        }

        return result;
    }
    public static void main(String[] args) {
        int[] arr = {-10,-5,-1};
        System.out.println(Arrays.toString(sortedSquares(arr)));
    }
}
