package amazon;

public class Remove_Duplicates {
    public static int removeDuplicates(int[] nums) {
        int ind = 1;

        for(int i=1;i<nums.length;i++) {
            if(nums[i] != nums[i-1])
                nums[ind++] = nums[i];
        }

        return ind;
    }
    public static void main(String[] args) {
        int[] arr = {0,0,1,1,1,2,2,3,3,4};
        System.out.println(removeDuplicates(arr));
    }
}
