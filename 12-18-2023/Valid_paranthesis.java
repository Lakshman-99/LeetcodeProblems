import java.util.*;

public class Valid_paranthesis {

    public static boolean isValid(String s) {
        HashMap<Character, Character> hm = new HashMap<>() {{
                put(')', '(');
                put('}','{');
                put(']','[');
        }};
        Stack<Character> st = new Stack<>();

        for(char c : s.toCharArray()) {
            if(Arrays.asList('[','(','{').contains(c)) {
                st.add(c);
            }
            else {
                if(!st.isEmpty() && hm.get(c) == st.peek()) {
                    st.pop();
                } else {
                    return false;
                }
            }
        }
        return st.isEmpty();
    }

    public static void main(String[] args) {
        boolean arr = isValid("(]");

        System.out.print(arr + " ");
    }
}
