//  1752. Check if Array Is Sorted and Rotated
//
//  https://leetcode.com/problems/check-if-array-is-sorted-and-rotated/description/
public class Check_If_Array_Is_Sorted_And_Rotated {
    public static boolean check(int[] nums) {
        boolean flag = false;
        for(int i=1;i<nums.length;i++) {
            if(nums[i-1]>nums[i]) {
                if(flag) return false;
                if(!flag) flag = true;
            }
        }
        if(flag) {
            if(nums.length == 3 && nums[0] != nums[nums.length-1]) return false;
            if(nums[0] < nums[nums.length-1]) return false;
        }

        return true;
    }
    public static void main(String[] args) {
        int[] arr = new int[]{6,4,5};
        System.out.print(check(arr));
    }
}
