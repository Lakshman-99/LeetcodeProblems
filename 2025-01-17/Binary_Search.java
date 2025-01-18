// 704. Binary Search

// https://leetcode.com/problems/binary-search/description

public class Binary_Search {
    public static int search(int[] nums, int target) {
        int left = 0, right = nums.length-1;

        while(left <= right) {
            int mid = left + (right - left) / 2;

            if(nums[mid] == target)
                return mid;
            else if(target < nums[mid])
                right = mid - 1;
            else
                left = mid + 1;
        }

        return -1;
    }
    public static void main(String[] args) {
        int[] arr = {-1,0,3,5,9,12};
        System.out.println(search(arr, 2));
    }
}
