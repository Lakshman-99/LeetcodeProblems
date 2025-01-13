package practice;

import java.util.Arrays;

public class Next_Permutation {
    public static void nextPermutation(int[] nums) {
        int n = nums.length;
        int ind = -1;

        for(int i=n-2;i>=0;i--) {
            if(nums[i] < nums[i+1]) {
                ind = i;
                break;
            }
        }

        if(ind==-1) {
            reverse(nums, 0, n-1);
            return;
        }

        for(int i=n-1;i>ind;i--) {
            if(nums[i] > nums[ind]) {
                swap(nums, i, ind);
                break;
            }
        }

        reverse(nums, ind+1, n-1);
    }

    public static void reverse(int[] nums, int s, int e) {
        while(s < e) {
            swap(nums, s++, e--);
        }
    }

    public static void swap(int[] nums, int s, int e) {
        int t = nums[s];
        nums[s] = nums[e];
        nums[e] = t;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,3,2};
        nextPermutation(arr);
        System.out.println(Arrays.toString(arr));
    }
}
