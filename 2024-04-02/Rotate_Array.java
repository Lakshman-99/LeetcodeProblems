//  189. Rotate Array
//
//  https://leetcode.com/problems/rotate-array/description/

import java.util.Arrays;

public class Rotate_Array {
    public static void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k%n;
        int i = 0;
        int[] arr = nums.clone();
        for(int j=n-k;j<n;j++) {
            nums[i++] = nums[j];
        }
        for(int j=0;j<n-k;j++) {
            nums[i++] = arr[j];
        }
    }
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,5,6,7};
        rotate(arr, 3);
        System.out.println(Arrays.toString(arr));
    }
}
