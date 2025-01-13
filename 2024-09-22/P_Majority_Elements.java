public class P_Majority_Elements {
    public static int majorityElement(int[] nums) {
        int count = 0, element = nums[0];

        for(int num : nums) {
            if(num == element) {
                count++;
            }
            else if(count > 0) {
                count--;
            }
            else {
                element = num;
                count++;
            }
        }
        return element;
    }
    public static void main(String[] args) {
        int[] nums = new int[]{2,2,1,1,1,2,2};
        System.out.println(majorityElement(nums));
    }
}
