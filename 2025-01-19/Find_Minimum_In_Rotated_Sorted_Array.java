// 153. Find Minimum in Rotated Sorted Array

// https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/description

public class Find_Minimum_In_Rotated_Sorted_Array {
    public static int findMin(int[] nums) {
        int min = Integer.MAX_VALUE;
        int s = 0, e = nums.length - 1;

        while(s <= e) {
            int mid = (s + e) / 2;

            min = Math.min(min, nums[mid]);

            if(nums[s] <= nums[mid]) {
                if(nums[mid] <= nums[e])
                    e = mid - 1;
                else
                    s = mid + 1;
            }
            else {
                if (nums[mid] >= nums[e])
                    s = mid + 1;
                else
                    e = mid - 1;
            }
        }

        return min;
    }
    public static void main(String[] args) {
        int[] arr = {3,4,5,1,2};

        // 5,1,2,3,4
        // 5,4,3,2,1
        // 1,2,3,4,5

        System.out.println(findMin(arr));
    }
}
