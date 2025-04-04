package amazon;

import java.util.HashMap;
import java.util.Stack;

public class Valid_Parentheses {
    public static boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        HashMap<Character, Character> map = new HashMap<>();
        map.put(')','(');
        map.put(']','[');
        map.put('}','{');

        for(char c : s.toCharArray()) {
            if(st.isEmpty()) {
                if(map.containsKey(c))
                    return false;
                st.add(c);
            }
            else {
                if(map.containsKey(c) && st.peek() == map.get(c)) {
                    st.pop();
                }
                else {
                    st.add(c);
                }
            }
        }

        return st.isEmpty();
    }
    public static void main(String[] args) {
        System.out.println(isValid("()[]{{}}"));
    }
}
