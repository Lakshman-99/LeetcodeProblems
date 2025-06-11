package patterns.two_pointers;

import java.util.Arrays;

public class Two_Sum_II___Input_Array_Is_Sorted {
    public static int[] twoSum(int[] numbers, int target) {
        int left = 0, right = numbers.length-1;

        while(left < right) {
            int sum = numbers[left] + numbers[right];
            if(sum == target) {
                return new int[]{left+1, right+1};
            }

            if(sum > target) {
                right--;
            }
            else {
                left++;
            }
        }

        return new int[0];
    }
    public static void main(String[] args) {
        int[] arr = {2,7,11,15};
        System.out.println(Arrays.toString(twoSum(arr, 9)));
    }
}
