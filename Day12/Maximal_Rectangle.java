import java.util.Stack;

public class Maximal_Rectangle {
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
    public static int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return 0;

        int cols = matrix[0].length;
        int[] heights = new int[cols + 1];
        int maxArea = 0;

        for (char[] row : matrix) {
            for (int i = 0; i < cols; i++) {
                heights[i] = (row[i] == '1') ? heights[i] + 1 : 0;
            }
            int ans = largestRectangleArea(heights);
            maxArea = Math.max(ans, maxArea);
        }

        return maxArea;
    }
    public static void main(String[] args) {
        char[][] matrix = new char[][]{
                {'1','0','1','0','0'},
                {'1','0','1','1','1'},
                {'1','1','1','1','1'},
                {'1','0','0','1','0'}
        };
        int result = maximalRectangle(matrix);
        System.out.println(result);
    }
}
