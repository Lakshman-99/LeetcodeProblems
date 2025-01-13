//  2370. Longest Ideal Subsequence
//
//  https://leetcode.com/problems/longest-ideal-subsequence/description/

import java.util.Arrays;

public class Longest_Ideal_Subsequence {
    public static int longestIdealString(String s, int k) {
        int n = s.length();
        int ans = 0;
        int[] dp = new int[150];
        for(int i=0;i<n;i++) {
            int curMax = 0, ch = s.charAt(i);
            for(int j=ch-k;j<=ch+k;j++) {
                curMax = Math.max(curMax, dp[j]+1);
            }
            ans = Math.max(ans, dp[ch] = curMax);
        }
        return ans;
    }
    public static void main(String[] args) {
        int ans = longestIdealString("acfgbd", 2);
        System.out.println(ans);
    }

}
