// 5. Longest_Palindromic_Substring

// https://leetcode.com/problems/longest-palindromic-substring/description/

public class Longest_Palindromic_Substring {
    public static String longestPalindrome(String s) {
        int maxLen = 0;
        String ans = "";

        for(int i=0;i<s.length();i++) {
            int l = i, r = i;
            while(l>=0 && r<s.length() && s.charAt(l) == s.charAt(r)) {
                if(r-l+1 > maxLen) {
                    maxLen = r - l + 1;
                    ans = s.substring(l, r+1);
                }
                l--;
                r++;
            }

            l=i;
            r=i+1;
            while(l>=0 && r<s.length() && s.charAt(l) == s.charAt(r)) {
                if(r-l+1 > maxLen) {
                    maxLen = r - l + 1;
                    ans = s.substring(l, r+1);
                }
                l--;
                r++;
            }
        }

        return ans;
    }
    public static void main(String[] args) {
        String s = "bababdbab";
        System.out.println(longestPalindrome(s));
    }
}
