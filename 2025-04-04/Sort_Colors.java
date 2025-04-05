package amazon;

import java.util.Arrays;

public class Sort_Colors {
    public static void sortColors(int[] nums) {
        int[] color = new int[3];
        for(int num : nums)
            color[num]++;

        int ind = 0;
        for(int i=0;i<3;i++) {
            int c = color[i];
            while(c-- > 0) {
                nums[ind++] = i;
            }
        }
    }
    public static void main(String[] args) {
        int[] colors = {0,1,2,0,0,2,1,2};
        sortColors(colors);
        System.out.println(Arrays.toString(colors));
    }
}
