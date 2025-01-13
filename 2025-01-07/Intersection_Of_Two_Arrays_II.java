// 350. Intersection of Two Arrays II

// https://leetcode.com/problems/intersection-of-two-arrays-ii/description

import java.util.Arrays;

public class Intersection_Of_Two_Arrays_II {
    public static int[] intersect(int[] nums1, int[] nums2) {
        int[] fre = new int[1001];
        int[] fre2 = new int[1001];

        for(int num : nums1)
            fre[num]++;

        for(int num : nums2)
            fre2[num]++;

        int c = 0, j = 0;

        for(int i=0;i<1001;i++) {
            if(fre[i] != 0 && fre2[i] != 0) {
                c += Math.min(fre[i], fre2[i]);
            }
        }

        int[] ans = new int[c];
        for(int i=0;i<1001;i++) {
            if (fre[i] != 0 && fre2[i] != 0) {
                c = Math.min(fre[i], fre2[i]);

                while(c > 0) {
                    ans[j++] = i;
                    c--;
                }
            }
        }

        return ans;
    }
    public static void main(String[] args) {
        int[] arr1 = new int[]{1,2,2,1};
        int[] arr2 = new int[]{2,2};

        System.out.println(Arrays.toString(intersect(arr1, arr2)));
    }
}
