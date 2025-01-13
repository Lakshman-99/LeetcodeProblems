public class Reverse_Prefix_Of_Word {
    public static String reversePrefix(String word, char ch) {
        return new StringBuilder(word.substring(0, word.indexOf(ch)+1)).reverse() + word.substring(word.indexOf(ch)+1);
    }

    public static void main(String[] args) {
        String ans = reversePrefix("xyxzxe", 'z');
        System.out.println(ans);
    }
}
