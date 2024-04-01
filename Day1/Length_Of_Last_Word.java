//   58. Length of Last Word
//
//  https://leetcode.com/problems/length-of-last-word/description/

public class Length_Of_Last_Word {
    public static int lengthOfLastWord(String s) {
        return s.split(" ")[s.split(" ").length - 1].length();
    }

    public static void main(String[] args) {
        int len = lengthOfLastWord("Hello World");
        System.out.println(len);
    }
}
