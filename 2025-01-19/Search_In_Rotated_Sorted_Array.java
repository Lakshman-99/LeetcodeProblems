package practice;

public class Search_In_Rotated_Sorted_Array {
    public static int search(int[] nums, int target) {
        int s = 0, e = nums.length - 1;

        while(s <= e) {
            int mid = s + (e - s) / 2;

            if(nums[mid] == target)
                return mid;

            if(nums[mid] >= nums[s]) {
                if(nums[s] <= target && target <= nums[mid])
                    e = mid - 1;
                else
                    s = mid + 1;
            }
            else {
                if(nums[mid] <= target && target <= nums[e])
                    s = mid + 1;
                else
                    e = mid - 1;
            }
        }

        return -1;
    }
    public static void main(String[] args) {
        int[] arr = {4,5,6,7,0,1,2};
        System.out.println(search(arr, 0));
    }
}
