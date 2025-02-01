import java.util.Stack;

public class Sort_A_Stack {
    public static void sortStack(Stack<Integer> stack) {
        // Write your code here.
        Stack<Integer> temp = new Stack<>();

        while(stack.isEmpty()) {
            if(!temp.isEmpty() && temp.peek() > stack.peek()) {
                
            }
            temp.add(stack.pop());
        }

    }
    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();
        int[] arr = {5, -2, 9, -7, 3};

        for(int num : arr)
            st.add(num);

        sortStack(st);

        while(!st.isEmpty()) {
            System.out.println(st.pop());
        }
    }
}
