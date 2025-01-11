package practice;

import java.util.Arrays;

public class Product_Of_Array_Except_Self {
    public static int[] productExceptSelf(int[] nums) {
        int n = nums.length;

        int[] pre = new int[n];
        int[] suf = new int[n];

        int c = 1;
        for(int i=0;i<n;i++) {
            pre[i] = c;
            c *= nums[i];
        }

        c=1;
        for(int i=n-1;i>=0;i--) {
            suf[i] = c;
            c *= nums[i];
        }

        for(int i=0;i<n;i++) {
            nums[i] = pre[i] * suf[i];
        }

        return nums;
    }
    public static void main(String[] args) {
        int[] arr1 = new int[]{-1,1,0,-3,3};
        System.out.println(Arrays.toString(productExceptSelf(arr1)));
    }
}
