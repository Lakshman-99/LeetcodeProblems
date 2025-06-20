package patterns.two_pointers;

import java.util.Arrays;

public class Sort_Array_By_Parity_II {
    public static int[] sortArrayByParityII(int[] nums) {
        if(nums == null || nums.length == 0) return new int[]{};

        int[] result = new int[nums.length];
        int even = 0, odd = 1;
        for (int num : nums) {
            if (num % 2 == 0) {
                result[even] = num;
                even += 2;
            } else {
                result[odd] = num;
                odd += 2;
            }
        }
        return result;
    }
    public static void main(String[] args) {
        int[] arr = {4,2,5,7};
        System.out.println(Arrays.toString(sortArrayByParityII(arr)));
    }
}
