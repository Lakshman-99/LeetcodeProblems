// 493. Reverse Pairs

// https://leetcode.com/problems/reverse-pairs/description/

import java.util.ArrayList;

public class Reverse_Pairs {
    public static int mergeSort(int[] nums, int low, int mid, int high) {
        ArrayList<Integer> arr = new ArrayList<>();
        int left = low;
        int right = mid + 1;
        int c = 0;

        for(int i=low;i<=mid;i++) {
            while(right <= high && nums[i] > 2L * nums[right]) {
                right++;
            }
            c = c + (right - (mid + 1));
        }

        right = mid + 1;

        while(left <= mid && right <= high) {
            if(nums[left] <= nums[right])
                arr.add(nums[left++]);
            else
                arr.add(nums[right++]);
        }

        while(left <= mid)
            arr.add(nums[left++]);

        while(right <= high)
            arr.add(nums[right++]);

        for(int i=low;i<=high;i++)
            nums[i] = arr.get(i - low);

        return c;
    }
    public static int merge(int[] nums, int low, int high) {
        int c = 0;
        if(low >= high)
            return 0;

        int mid = (low + high) / 2;
        c += merge(nums, low, mid);
        c += merge(nums, mid+1, high);
        c += mergeSort(nums, low, mid, high);

        return c;
    }
    public static int reversePairs(int[] nums) {
        return merge(nums, 0, nums.length - 1);
    }
    public static void main(String[] args) {
        int[] arr1 = new int[]{1,3,2,3,1};
        System.out.println(reversePairs(arr1));
    }
}
