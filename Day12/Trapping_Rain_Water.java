//  42. Trapping Rain Water
//
//  https://leetcode.com/problems/trapping-rain-water/description

public class Trapping_Rain_Water {
    public static int trap(int[] height) {
        int l = 0;
        int r = height.length-1;
        int left_max = height[0];
        int right_max = height[r];
        int water = 0;
        while(l<r){
            if(left_max<=right_max){
                water += (left_max-height[l]);
                l++;
                left_max = Math.max(left_max,height[l]);
            }else{
                water += (right_max-height[r]);
                r--;
                right_max = Math.max(right_max,height[r]);
            }
        }
        return water;
    }
    public static void main(String[] args) {
        int result = trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1});
        System.out.println(result);
    }
}
