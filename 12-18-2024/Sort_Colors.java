package practice;

import java.util.Arrays;

public class Sort_Colors {
    public static void sortColors(int[] nums) {
        int[] arr = new int[3];

        for(int num : nums)
            arr[num]++;

        int i = 0;
        for(int j=0;j<arr.length;j++) {
            int x = arr[j];
            while(x-- > 0) {
                nums[i++] = j;
            }
        }
    }
    public static void main(String[] args) {
        int[] arr = new int[]{2,0,2,1,1,0};
        sortColors(arr);
        System.out.println(Arrays.toString(arr));
    }
}
