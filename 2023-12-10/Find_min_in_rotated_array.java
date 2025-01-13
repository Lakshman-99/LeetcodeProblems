public class Find_min_in_rotated_array {
    public static int findMin(int[] nums) {
        int l = 0, r = nums.length - 1;

        while (nums[l] > nums[r]) {
            int m = (l + r) / 2;

            if (nums[l] <= nums[m])
                l = m + 1;
            else
                r = m;
        }

        return nums[l];
    }

    public static void main(String[] args) {
        int arr = findMin(new int[]{6,7,1,2,3,4,5});

        System.out.print(arr + " ");
    }
}
