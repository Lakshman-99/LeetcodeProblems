// 540. Single Element in a Sorted Array

// https://leetcode.com/problems/single-element-in-a-sorted-array/description

public class Single_Element_In_A_Sorted_Array {
    public static int singleNonDuplicate(int[] nums) {
        int s = 0, e = nums.length - 1;
        while(s<e) {
            int mid = (s + e) / 2;

            if(mid % 2 == 1) mid--;

            if(nums[mid] != nums[mid+1])
                e = mid;
            else
                s = mid+2;
        }

        return nums[s];
    }
    public static void main(String[] args) {
        int[] arr = {1,1,2,2,4,4,5,5,9};
        System.out.println(singleNonDuplicate(arr));
    }
}
