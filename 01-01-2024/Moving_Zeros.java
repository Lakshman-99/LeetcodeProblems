import java.util.Arrays;

public class Moving_Zeros {
    public static void moveZeroes(int[] nums) {
        int n = nums.length;
        int i =0;
        for(int j=0;j<n;j++) {
            if(nums[j] != 0) {
                nums[i++] = nums[j];
            }
        }
        while(i<n) {
            nums[i++] = 0;
        }
    }
    public static void main(String[] args) {
        int[] arr = new int[]{0,1,0,3,12};
        moveZeroes(arr);
        System.out.println(Arrays.toString(arr));
    }
}
