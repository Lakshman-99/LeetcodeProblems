//  125. Valid Palindrome
//
//  https://leetcode.com/problems/valid-palindrome/description/

public class Valid_Palindrome {
    public static boolean isPalindrome(String s) {
        s = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        int n = s.length();
        if(n == 2) return s.charAt(0) == s.charAt(1);
        int mid = n%2 == 1 ? n/2+1 : n/2;
        String s1 = s.substring(0, n / 2);
        StringBuilder s2 = new StringBuilder(s.substring(mid, n));
        return s1.contentEquals(s2.reverse());
    }
    public static boolean isPalindrome2(String s) {
        s = s.replaceAll("\\s", "").toLowerCase();
        int i=0, j=s.length()-1;

        while(i<=j) {
            if(s.charAt(i++) != s.charAt(j--)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome2("A man, a plan, a canal: Panama"));
    }
}
