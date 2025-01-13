// 349. Intersection of Two Arrays

// https://leetcode.com/problems/intersection-of-two-arrays/description

import java.util.Arrays;

public class Intersection_Of_Two_Arrays {
    public static int[] intersection(int[] nums1, int[] nums2) {
        int[] fre = new int[1000];
        int[] fre2 = new int[1000];
        int c = 0;

        for(int num : nums1)
            fre[num]++;

        for(int num : nums2)
            fre2[num]++;

        for(int i=0;i<1000;i++)
            if(fre[i] > 0 && fre2[i] > 0)
                c++;

        int[] ans = new int[c];
        int j = 0;
        for(int i=0;i<1000;i++) {
            if(fre[i] > 0 && fre2[i] > 0)
                ans[j++] = i;
        }

        return ans;
    }
    public static void main(String[] args) {
        int[] arr1 = new int[]{4,9,5};
        int[] arr2 = new int[]{9,4,9,8,4};

        System.out.println(Arrays.toString(intersection(arr1, arr2)));

    }
}
