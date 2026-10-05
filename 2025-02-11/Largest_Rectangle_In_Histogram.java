package practice;

import java.util.Stack;

public class Largest_Rectangle_In_Histogram {
    public static int largestRectangleArea(int[] heights) {
        Stack<Integer> st = new Stack<>();
        int ans = 0, n=heights.length;

        for(int i=0;i<=n;i++) {
            while(!st.isEmpty() && (i==n || heights[st.peek()] >= heights[i])) {
                int h = heights[st.pop()];
                int w = st.isEmpty() ? i : i - st.peek() - 1;
                ans = Math.max(ans, h * w);
            }
            st.add(i);
        }

        return ans;
    }
    public static void main(String[] args) {
        int[] arr = {2,1,5,6,2,3};
        System.out.println(largestRectangleArea(arr));
    }
}
