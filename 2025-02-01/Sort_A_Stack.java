import java.util.Stack;

public class Sort_A_Stack {
    public static void insert(Stack<Integer> stack, int top) {
        if(stack.isEmpty()){
            stack.add(top);
            return;
        }
        if(stack.peek() > top) {
            int curTop = stack.pop();
            insert(stack, top);
            stack.add(curTop);
        }
        else {
            stack.add(top);
        }
    }
    public static void sortStack(Stack<Integer> stack) {
        // Write your code here.
        if(stack.isEmpty()) return;

        int top = stack.pop();
        sortStack(stack);
        insert(stack, top);
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
