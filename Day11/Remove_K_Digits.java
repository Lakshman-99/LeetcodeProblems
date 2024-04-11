//  402. Remove K Digits
//
//  https://leetcode.com/problems/remove-k-digits/

import java.util.*;

public class Remove_K_Digits {
    public static String removeKdigits(String num, int k) {
        StringBuilder sb = new StringBuilder();
        Stack<Character> st = new Stack<>();

        for(char c : num.toCharArray()){
            while(!st.isEmpty() && k > 0 && st.peek() > c){
                st.pop();
                k--;
            }
            st.push(c);
        }
        while(!st.isEmpty()){
            if(k-- > 0) st.pop();
            else sb.insert(0, st.pop());
        }

        while(sb.length()>0 && sb.charAt(0)=='0')
            sb.deleteCharAt(0);

        return sb.length()==0 ? "0" : sb.toString();
    }
    public static void main(String[] args) {
        String input = "1432219";
        String result = removeKdigits(input, 3);
        System.out.println(result);
    }
}
