public class Max_sub_array_sum {
    public static int maxSubArray(int[] nums) {
        int max = nums[0], sum=0;
        for(int num : nums) {
            sum+=num;
            if(sum>max) {
                max = sum;
            }
            if(sum < 0) {
                sum =0;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int arr = maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4});

        System.out.print(arr + " ");
    }
}
