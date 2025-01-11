//  678. Valid Parenthesis String
//
//  https://leetcode.com/problems/valid-parenthesis-string/description

import java.util.Arrays;

public class Valid_Paranthesis_String {
    public static boolean solve(int n, int val, char[] s, int[][] dp) {
        if(n == s.length) {
            return val == 0;
        }
        if(val<0) {
            return false;
        }
        if(dp[n][val] != -1) {
            return dp[n][val] == 1;
        }
        boolean ans = false;
        if(s[n] == '(') {
            ans = solve(n+1, val+1, s, dp);
        }
        else if(s[n] == ')') {
            ans = solve(n + 1, val - 1, s, dp);
        }
        else {
            ans = solve(n+1, val, s, dp) || solve(n+1, val+1, s, dp) || solve(n+1, val-1, s, dp);
        }
        dp[n][val] = ans ? 1 : 0;
        return dp[n][val] == 1;
    }
    public static boolean checkValidString(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        for(int[] r : dp) {
            Arrays.fill(r, -1);
        }

        return solve(0, 0, s.toCharArray(), dp);
    }

    public static void main(String[] args) {
        System.out.println(checkValidString("(**))))())"));
    }
}
