//  88. Merge Sorted Array
//
//  https://leetcode.com/problems/merge-sorted-array/description/

import java.util.Arrays;

public class Merge_Sorted_Array {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] ans = new int[m+n];

        int i=0, j=0, ptr=0;
        while(i<m && j<n) {
            if(nums1[i]<nums2[j]) {
                ans[ptr++] = nums1[i++];
            }
            else if(nums1[i] > nums2[j]) {
                ans[ptr++] = nums2[j++];
            }
            else {
                ans[ptr++] = nums1[i++];
                ans[ptr++] = nums2[j++];
            }
        }
        while(i<m) {
            ans[ptr++] = nums1[i++];
        }
        while(j<n) {
            ans[ptr++] = nums2[j++];
        }
        for(i=0;i<m+n;i++) {
            nums1[i] = ans[i];
        }
    }
    public static void main(String[] args) {
        int[] arr1 = new int[]{0};
        int[] arr2 = new int[]{1};
        int n = 0, m = 1;
        merge(arr1, n, arr2, m);
        System.out.println(Arrays.toString(arr1));
    }
}
