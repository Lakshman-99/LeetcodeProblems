package practice;

public class Largest_Palindromic_Substring {
    public static String longestPalindrome(String s) {
        int max = 0;
        int n = s.length();
        String ans = "";

        for(int i=0;i<n;i++) {
            int l=i, r=i;
            while(l>=0 && r<n && s.charAt(l) == s.charAt(r)) {
                if(r-l+1 > max) {
                    max = r-l+1;
                    ans = s.substring(l, r+1);
                }
                l--;
                r++;
            }

            l=i;
            r=i+1;
            while(l>=0 && r<n && s.charAt(l) == s.charAt(r)) {
                if(r-l+1 > max) {
                    max = r-l+1;
                    ans = s.substring(l, r+1);
                }
                l--;
                r++;
            }
        }

        return ans;
    }
    public static void main(String[] args) {
        String s = "babad";
        System.out.println(longestPalindrome(s));
    }
}
