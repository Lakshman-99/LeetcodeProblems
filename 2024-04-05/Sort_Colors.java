//  75. Sort Colors
//
//  https://leetcode.com/problems/sort-colors/description/

import java.util.Arrays;

public class Sort_Colors {
    public static void sortColors(int[] nums) {
        int[] count = new int[3];
        for(int num : nums)
            count[num]++;

        int ind = 0;
        for(int i=0;i<3;i++) {
            int temp = count[i];
            while(temp != 0) {
                nums[ind++] = i;
                temp--;
            }
        }
    }
    public static void main(String[] args) {
        int[] num = new int[]{2,0,2,1,1,0};
        sortColors(num);
        System.out.println(Arrays.toString(num));
    }
}
