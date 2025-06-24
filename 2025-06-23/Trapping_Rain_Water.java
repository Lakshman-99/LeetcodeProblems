package patterns.two_pointers;

public class Trapping_Rain_Water {
    public static int trap(int[] height) {
        if(height == null || height.length == 0) return 0;

        int n = height.length;
        int left = 0, right = n-1;
        int leftMax = height[0], rightMax = height[n-1];
        int total = 0;

        while(left<right) {
            if(leftMax <= rightMax) {
                total += leftMax - height[left++];
                leftMax = Math.max(leftMax, height[left]);
            }
            else {
                total += rightMax - height[right--];
                rightMax = Math.max(rightMax, height[right]);
            }
        }

        return total;
    }
    public static void main(String[] args) {
        int[] arr = {5,5,1,7,1,1,5,2,7,6};
        System.out.println(trap(arr));
    }
}
