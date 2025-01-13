// 496. Next Greater Element I

// https://leetcode.com/problems/next-greater-element-i/description/?envType=problem-list-v2&envId=array

import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

public class Next_Greater_Element_I {
    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        Stack<Integer> st = new Stack<>();

        for(int num : nums2) {
            while(!st.isEmpty() && st.peek() < num) {
                map.put(st.pop(), num);
            }
            st.add(num);
        }

        for(int i=0;i<nums1.length;i++)
            nums1[i] = map.getOrDefault(nums1[i], -1);

        return nums1;
    }
    public static void main(String[] args) {
        int[] arr1 = new int[]{4,1,2};
        int[] arr2 = new int[]{1,3,4,2};
        System.out.println(Arrays.toString(nextGreaterElement(arr1, arr2)));
    }
}
