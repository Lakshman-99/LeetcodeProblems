//  84. Largest Rectangle in Histogram
//
//  https://leetcode.com/problems/largest-rectangle-in-histogram/description/

import java.util.Stack;

public class Largest_Rectangle_In_Histogram {
    public static int largestRectangleArea(int[] heights) {
        Stack<Integer> st = new Stack<>();
        int n = heights.length;

        int[] left = new int[n];
        int[] right = new int[n];

        for(int i=0;i<n;i++) {
            while(!st.isEmpty() && heights[st.peek()] >= heights[i]) {
                st.pop();
            }
            if(st.isEmpty()) left[i] = 0;
            else left[i] = st.peek() + 1;
            st.push(i);
        }
        st.clear();

        for(int i=n-1;i>=0;i--) {
            while(!st.isEmpty() && heights[st.peek()] >= heights[i]) {
                st.pop();
            }
            if(st.isEmpty()) right[i] = n-1;
            else right[i] = st.peek() - 1;
            st.push(i);
        }

        int ans = 0;
        for(int i=0;i<n;i++) {
            ans = Math.max(ans, heights[i]*(right[i] - left[i] + 1));
        }

        return ans;
    }
    public static void main(String[] args) {
        int result = largestRectangleArea(new int[]{0,9});
        System.out.println(result);
    }
}
