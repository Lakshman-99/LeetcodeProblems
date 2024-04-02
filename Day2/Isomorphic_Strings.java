//  205. Isomorphic Strings
//
//  https://leetcode.com/problems/isomorphic-strings/description/

import java.util.Arrays;

public class Isomorphic_Strings {
    public static boolean solve(String s, String t) {
        if(s.length() != t.length()) return false;
        int[] fre1 = new int[256];
        Arrays.fill(fre1, -1);

        for(int i=0;i<s.length();i++) {
            char c = s.charAt(i);
            char x = t.charAt(i);

            if(fre1[c] != -1 && fre1[c] != x) {
                return false;
            }
            fre1[c] = x;
        }

        return true;
    }
    public static boolean isIsomorphic(String s, String t) {
        return solve(s, t) && solve(t, s);
    }
    public static void main(String[] args) {
        boolean ans = isIsomorphic("paper", "title");
        System.out.println(ans);
    }
}
