public class Max_sub_array_prod {
    public static int maxProduct(int[] nums) {
        int max = nums[0], prod=1;
        for(int num : nums) {
            prod*=num;
            if(prod>max) {
                max = prod;
            }
            if(prod == 0) {
                prod = 1;
            }
        }
        prod = 1;
        for(int i= nums.length-1; i>=0;i--) {
            prod*=nums[i];
            if(prod>max) {
                max = prod;
            }
            if(prod == 0) {
                prod = 1;
            }
        }

        return max;
    }

    public static void main(String[] args) {
        int arr = maxProduct(new int[]{1,-3,4});

        System.out.print(arr + " ");
    }
}
