// 448. Find All Numbers Disappeared in an Array

// https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/description

import java.util.ArrayList;
import java.util.List;

public class Find_All_Numbers_Disappeared_In_An_Array {
    public static List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> ans = new ArrayList<>();

        for(int i=0;i<nums.length;i++) {
            int num = Math.abs(nums[i]) - 1;
            if(nums[num] > 0) {
                nums[num] = -1 * nums[num];
            }
        }

        for(int i=0;i<nums.length;i++) {
            if(nums[i] > 0) {
                ans.add(i+1);
            }
        }

        return ans;
    }
    public static void main(String[] args) {
        int[] arr = new int[]{4,3,2,7,8,2,3,1};
        System.out.println(findDisappearedNumbers(arr));
    }
}
