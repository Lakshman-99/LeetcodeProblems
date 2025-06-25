package patterns.two_pointers;

public class Expressive_Words {
    public static boolean helper(String s, String word) {
        int left = 0;
        for(int i=0;i<s.length();i++) {
            if(left < word.length() && s.charAt(i) == word.charAt(left)) left++;
            else if(i > 1 && s.charAt(i) == s.charAt(i-1) && s.charAt(i-2) == s.charAt(i-1));
            else if(i > 0 && i < s.length()-1 && s.charAt(i) == s.charAt(i-1) && s.charAt(i) == s.charAt(i+1));
            else return false;
        }
        return left == word.length();
    }
    public static int expressiveWords(String s, String[] words) {
        int result = 0;

        for(String word : words) {
            result += helper(s, word) ? 1 : 0;
        }

        return result;
    }
    public static void main(String[] args) {
        String[] words = {"hello", "hi", "helo"};
        System.out.println(expressiveWords("heeellooo", words));
    }
}
