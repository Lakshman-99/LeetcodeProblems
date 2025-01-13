// 2149. Rearrange Array Elements by Sign

// https://leetcode.com/problems/rearrange-array-elements-by-sign/description/

import java.util.Arrays;

public class Rearrange_Array_Elements_By_Sign {
    public static int[] rearrangeArray(int[] nums) {
        int[] dup = new int[nums.length];

        int pos=0, neg=1;
        for(int i=0;i<nums.length;i++) {
            if(nums[i] > 0) {
                dup[pos] = nums[i];
                pos+=2;
            } else {
                dup[neg] = nums[i];
                neg+=2;
            }
        }
        return dup;
    }
    public static void main(String[] args) {
        int[] arr = new int[]{3,1,-2,-5,2,-4};
        System.out.println(Arrays.toString(rearrangeArray(arr)));
    }
}
