// 20. Valid Parentheses

// https://leetcode.com/problems/valid-parentheses/description

import java.util.Stack;

public class Valid_Parentheses {
    private static boolean isPair(char last, char cur) {
        return (last == '(' && cur == ')') ||
                (last == '{' && cur == '}') ||
                (last == '[' && cur == ']');
    }
    public static boolean isValid(String s) {
        Stack<Character> st = new Stack<>();

        for(char c : s.toCharArray()) {
            if(")}]".contains(c+"")) {
                if(st.isEmpty() || !isPair(st.peek(), c))
                    return false;
                if(isPair(st.peek(), c))
                    st.pop();
            }
            else {
                st.add(c);
            }
        }

        return st.isEmpty();
    }
    public static void main(String[] args) {
        String s = "()";
        System.out.println(isValid(s));
    }
}
