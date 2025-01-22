package practice;

public class Median_Of_Two_Sorted_Arrays {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums2.length < nums1.length) return findMedianSortedArrays(nums2, nums1);

        int low1 = 0, high1 = nums1.length;

        while(low1 <= high1) {
            int mid1 = (high1 + low1) / 2;
            int mid2 = (nums1.length + nums2.length + 1) / 2 - mid1;

            int l1 = Integer.MIN_VALUE, r1 = Integer.MAX_VALUE;
            int l2 = Integer.MIN_VALUE, r2 = Integer.MAX_VALUE;
            if(mid1>0) l1 = nums1[mid1 - 1];
            if(mid1<nums1.length) r1 = nums1[mid1];
            if(mid2>0) l2 = nums2[mid2 - 1];
            if(mid2<nums2.length) r2 = nums2[mid2];

            if(l1 <= r2 && l2 <= r1) {
                if((nums1.length + nums2.length) % 2 == 0)
                    return (Math.max(l1, l2) + Math.min(r1, r2)) / 2.0;
                return Math.max(l1, l2);
            }
            else if(l1 > r2) {
                high1 = mid1 - 1;
            }
            else {
                low1 = mid1 + 1;
            }
        }

        return 0.0;
    }
    public static void main(String[] args) {
        int[] arr = {3,4};
        int[] arr2 = {1,2};

        System.out.println(findMedianSortedArrays(arr, arr2));
    }
}
