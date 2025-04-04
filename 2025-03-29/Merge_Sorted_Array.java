package amazon;

import java.util.Arrays;

public class Merge_Sorted_Array {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m-1, j = n-1, k = nums1.length-1;

        while(j>=0) {
            if(i>=0 && nums1[i] > nums2[j]) {
                nums1[k--] = nums1[i--];
            }
            else {
                nums1[k--] = nums2[j--];
            }
        }
    }
    public static void main(String[] args) {
        int[] arr = {1,2,3,0,0,0};
        int[] arr2 = {2,5,6};
        merge(arr, 3, arr2, 3);
        System.out.println(Arrays.toString(arr));
    }
}
