package amazon;

public class Search_In_Rotated_Sorted_Array {
    public static int search(int[] nums, int target) {
        int start = 0, end = nums.length-1;

        while(start <= end) {
            int mid = (start + end) / 2;

            if(nums[mid] == target) return mid;

            if(nums[mid] >= nums[start]) {
                if(target >= nums[start] && target <= nums[mid])
                    end = mid;
                else
                    start = mid+1;
            }
            else {
                if(target >= nums[mid] && target <= nums[end]) {
                    start = mid+1;
                }
                else {
                    end = mid;
                }
            }
        }

        return -1;
    }
    public static void main(String[] args) {
        int[] arr = {5,1,3};
        System.out.println(search(arr, 5));
    }
}
