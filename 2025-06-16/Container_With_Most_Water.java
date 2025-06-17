package patterns.two_pointers;

public class Container_With_Most_Water {
    public static int maxArea(int[] height) {
        if(height == null || height.length == 0) return 0;

        int area = 0;
        int left = 0, right = height.length-1;
        while(left < right) {
            int h = Math.min(height[left], height[right]);
            int w = right - left;

            if(area < h*w) {
                area = h*w;
            }
            if(height[left] < height[right]) left++;
            else right--;
        }

        return area;
    }
    public static void main(String[] args) {
        int[] arr = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(arr));
    }
}
