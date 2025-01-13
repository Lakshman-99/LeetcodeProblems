//  80. Remove Duplicates from Sorted Array II
//
//  https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/description/


import java.util.Arrays;

public class Remove_Duplicates_From_Sorted_Array_II {
    public static int removeDuplicates(int[] nums) {
        int idx = 1;
        int count = 0;
        for(int i=1;i<nums.length;i++) {
            count = nums[i] == nums[i-1] ? count + 1 : 0;
            if(count <= 1){
                nums[idx++] = nums[i];
            }
        }
        return idx;
    }
    public static void main(String[] args) {
        int[] arr = new int[]{0,0,1,1,1,1,2,3,3};
        int ans = removeDuplicates(arr);
        System.out.println(ans);
        System.out.println(Arrays.toString(arr));
    }
}
