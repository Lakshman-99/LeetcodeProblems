package practice;

public class Remove_Duplicates_From_Sorted_Array_I {
    public static int removeDuplicates(int[] nums) {
        int ind = 1;

        for(int i=1;i<nums.length;i++) {
            if(nums[i] != nums[i - 1])
                nums[ind++] = nums[i];
        }

        return ind;
    }
    public static void main(String[] args) {
        int ans = removeDuplicates(new int[]{0,1,2,3,4});
        System.out.println(ans);
    }
}
