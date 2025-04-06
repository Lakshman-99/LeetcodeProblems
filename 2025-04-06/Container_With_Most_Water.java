package amazon;

public class Container_With_Most_Water {
    public static int maxArea(int[] height) {
        int left=0, right=height.length-1;
        int maxArea=0;

        while(left<right) {
            int length = right-left;
            int breath = Math.min(height[left], height[right]);
            maxArea = Math.max(maxArea, length*breath);

            if(height[left] < height[right])
                left++;
            else
                right--;
        }

        return maxArea;
    }
    public static void main(String[] args) {
        int[] arr = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(arr));
    }
}
