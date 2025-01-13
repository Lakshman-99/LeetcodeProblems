//  26. Remove Duplicates from Sorted Array
//
//  https://leetcode.com/problems/remove-duplicates-from-sorted-array/

import java.util.*;

public class Remove_Duplicates_From_Sorted_Array_I {
    public static int removeDuplicates(int[] nums) {
        LinkedHashSet<Integer> set = new LinkedHashSet<>();
        for(int num : nums) {
            set.add(num);
        }
        int i=0;
        for(int num : set) {
            nums[i++] = num;
        }
        return set.size();
    }
    public static void main(String[] args) {
        int ans = removeDuplicates(new int[]{0,0,1,1,1,2,2,3,3,4});
        System.out.println(ans);
    }
}
