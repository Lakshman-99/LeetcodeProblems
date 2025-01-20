package practice;

public class Search_In_Rotated_Sorted_Array_II {
    public static boolean search(int[] nums, int target) {
        int s = 0, e = nums.length - 1;

        while(s <= e) {
            int mid = (s + e) / 2;

            if(nums[mid] == target)
                return true;

            if(nums[s] == nums[mid]) {
                s++;
                continue;
            }

            if(nums[s] <= nums[mid]) {
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

        return false;
    }
    public static void main(String[] args) {
        int[] arr = {2,5,6,0,0,1,2};
        System.out.println(search(arr, -1));
    }
}
