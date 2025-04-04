package amazon;

public class Majority_Element {
    public static int majorityElement(int[] nums) {
        int candidate = nums[0], count = 1;

        for(int num : nums) {
            if(num == candidate) {
                count++;
            }
            else {
                count--;
            }

            if(count == 0) {
                candidate = num;
                count = 1;
            }
        }
        return candidate;
    }
    public static void main(String[] args) {
        int[] arr = {2,2,1,1,1,2,2};
        System.out.println(majorityElement(arr));
    }
}
