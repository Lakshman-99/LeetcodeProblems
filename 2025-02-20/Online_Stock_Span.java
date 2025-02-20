// 901. Online Stock Span

// https://leetcode.com/problems/online-stock-span/description/
import java.util.Stack;

public class Online_Stock_Span {
    public Stack<int[]> st;
    public Online_Stock_Span() {
        st = new Stack<>();
    }

    public int next(int price) {
        int day = 1;
        while(!st.isEmpty() && price >= st.peek()[0])
            day += st.pop()[1];

        st.add(new int[]{price, day});
        return day;
    }
    public static void main(String[] args) {
        Online_Stock_Span op = new Online_Stock_Span();

        System.out.println(op.next(100));
        System.out.println(op.next(80));
        System.out.println(op.next(60));
        System.out.println(op.next(70));
        System.out.println(op.next(60));
        System.out.println(op.next(75));
        System.out.println(op.next(85));

    }
}
