import java.util.Arrays;

public class Longest_Common_Subquence {

    public static int find(String t1, String t2, int n, int m, int[][] dp) {
        if(n<0 || m<0) {
            return 0;
        }
        if(dp[n][m] != -1) {
            return dp[n][m];
        }
        if(t1.charAt(n) == t2.charAt(m)) {
            return dp[n][m] = 1 + find(t1, t2, n-1, m-1, dp);
        }
        return dp[n][m] = Math.max(find(t1,t2,n-1,m,dp), find(t1,t2,n,m-1,dp));
    }
    public static int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        int[][] dp = new int[n][m];
        for(int[] row: dp) {
            Arrays.fill(row, -1);
        }
        return find(text1, text2, n-1, m-1, dp);
    }

    public static void main(String[] args) {
        String s1 = "abcde";
        String s2 = "acedb";
        System.out.println(longestCommonSubsequence(s1, s2));
    }
}
