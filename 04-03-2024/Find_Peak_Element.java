//  162. Find Peak Element
//
//  https://leetcode.com/problems/find-peak-element/description/

public class Find_Peak_Element {
    public static int findPeakElement(int[] nums) {
        int n = nums.length;
        int left=0;
        int right=n-1;
        while(left<right)
        {
            int mid = (left+right)/2;
            if(nums[mid]>nums[mid+1]) {
                right=mid;
            }
            else {
                left=mid+1;
            }
        }
        return left;
    }
    public static void main(String[] args) {
        int[] arr = new int[]{4,1,1,3,2,1,2};
        int ans = findPeakElement(arr);
        System.out.println(ans);
    }
}
