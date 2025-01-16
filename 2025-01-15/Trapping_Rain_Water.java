package practice;

public class Trapping_Rain_Water {
    public static int trap(int[] height) {
        int l = 0, r = height.length - 1;
        int lMax = height[l];
        int rMax = height[r];
        int ans = 0;

        while(l < r) {
            if(lMax <= rMax) {
                ans += (lMax - height[l++]);
                lMax = Math.max(lMax, height[l]);
            }
            else {
                ans += (rMax - height[r--]);
                rMax = Math.max(rMax, height[r]);
            }
        }

        return ans;
    }
    public static void main(String[] args) {
        int result = trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1});
        System.out.println(result);
    }
}
