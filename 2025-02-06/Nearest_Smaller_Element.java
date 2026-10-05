import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

public class Nearest_Smaller_Element {
    public static int[] prevSmaller(int[] arr) {
        Stack<Integer> st = new Stack<>();

        for(int i=0;i<arr.length;i++) {
            while(!st.isEmpty() && st.peek() >= arr[i]) {
                st.pop();
            }
            int num = arr[i];

            if(st.isEmpty()) arr[i] = -1;
            else arr[i] = st.peek();

            st.add(num);
        }

        return arr;
    }
    public static void main(String[] args) {
        int[] arr = {34, 35, 27, 42, 5, 28, 39, 20, 28};
        System.out.println(Arrays.toString(prevSmaller(arr)));
    }
}
