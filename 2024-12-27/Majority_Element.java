package practice;

public class Majority_Element {
    public static int majorityElement(int[] nums) {
        int max = nums[0], c = 1;

        for(int i=1;i<nums.length;i++) {
            if(nums[i] == max) {
                c++;
            }
            else {
                c--;
            }
            if(c == 0) {
                max = nums[i];
                c = 1;
            }
        }

        return max;
    }
    public static void main(String[] args) {
        int[] arr = new int[]{3,2,3};
        System.out.println(majorityElement(arr));
    }
}
