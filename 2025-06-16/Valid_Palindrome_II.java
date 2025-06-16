package patterns.two_pointers;

public class Valid_Palindrome_II {
    public static boolean helper(String s) {
        if(s == null || s.isEmpty()) return true;

        int left = 0, right = s.length()-1, remove = 1;
        while(left < right) {
            if(s.charAt(left) != s.charAt(right)) {
                if(remove-- == 0) return false;
                if(s.charAt(left) == s.charAt(right-1)) right--;
                else left++;
                continue;
            }
            left++;
            right--;
        }

        return true;
    }

    public static boolean validPalindrome(String s) {
        return helper(s) || helper(new StringBuilder(s).reverse().toString());
    }

    public static void main(String[] args) {
        System.out.println(validPalindrome("eceec"));
    }
}
