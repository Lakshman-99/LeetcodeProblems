package patterns.two_pointers;

import java.util.Arrays;

public class Sort_Array_By_Parity {
    public static int[] sortArrayByParity(int[] nums) {
        if(nums == null || nums.length == 0) return new int[]{};

        int n = nums.length;
        int[] result = new int[n];
        int left = 0, right = n-1;

        for (int num : nums) {
            if (num % 2 == 0) result[left++] = num;
            else result[right--] = num;
        }

        return result;
    }
    public static void main(String[] args) {
        int[] arr = {3,1,2,4};
        System.out.println(Arrays.toString(sortArrayByParity(arr)));
    }
}
