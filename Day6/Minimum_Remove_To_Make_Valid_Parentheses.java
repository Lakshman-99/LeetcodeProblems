//  1249. Minimum Remove to Make Valid Parentheses
//
//  https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses/description/

import java.util.*;

public class Minimum_Remove_To_Make_Valid_Parentheses {
    public static String minRemoveToMakeValid(String s) {
        Stack <Integer> st = new Stack<>();
        StringBuilder sb = new StringBuilder(s);
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='(') st.push(i);
            if(s.charAt(i)==')' && (st.isEmpty()||s.charAt(st.peek())==')')) st.push(i);
            if(s.charAt(i)==')' && s.charAt(st.peek())=='(') st.pop();
        }
        while(!st.isEmpty()){
            sb.deleteCharAt(st.pop());
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        String ans = minRemoveToMakeValid("lee(t(c)o)de)");
        System.out.println(ans);
    }
}
