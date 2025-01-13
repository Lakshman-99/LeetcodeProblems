package practice;

import java.util.Arrays;

public class Find_The_Duplicate_Number {
    public static int findDuplicate(int[] nums) {
        for(int num : nums) {
            int ind = Math.abs(num) - 1;
            if(nums[ind] < 0) {
                return ind + 1;
            }
            else {
                nums[ind] = -nums[ind];
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] arr1 = new int[]{1,3,4,2,2};
        System.out.println(findDuplicate(arr1));
    }
}
