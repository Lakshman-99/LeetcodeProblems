public class Valid_Palindrome_II {
    public static boolean isValidPalindrome(String s) {
        int i=0, j=s.length();

        while(i<=j) {
            char c1 = s.charAt(i++);
            char c2 = s.charAt(j--);
            if(c1 != c2) {

            }
        }
        return true;
    }
    public static void main(String[] args) {
        System.out.println(isValidPalindrome("abca"));
    }
}
