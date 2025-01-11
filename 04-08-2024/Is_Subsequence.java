//  392. Is Subsequence
//
//  https://leetcode.com/problems/is-subsequence/description/

public class Is_Subsequence {
    public static boolean isSubsequence(String s, String t) {
        int i=0,n=s.length();
        for(char c : t.toCharArray()) {
            if(s.charAt(i) == c) {
                i++;
            }
            if(i == n) {
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        System.out.println(isSubsequence("aec", "ahbgdc"));
    }
}
