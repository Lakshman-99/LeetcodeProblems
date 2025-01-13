import java.util.Arrays;

public class P_Sort_Colors {
    public static void sortColors(int[] nums) {
        int[] colors = new int[3];
        for(int num : nums)
            colors[num]++;

        int i=0;
        for(int c=0;c<3;c++) {
            int j = colors[c];
            while(j-->0)
                nums[i++] = c;
        }
    }
    public static void main(String[] args) {
        int[] colors = new int[]{2,0,2,1,1,0};
        sortColors(colors);
        System.out.println(Arrays.toString(colors));
    }
}
