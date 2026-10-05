// 345. Reverse Vowels of a String

// https://leetcode.com/problems/reverse-vowels-of-a-string/description

public class Reverse_Vowels_Of_A_String {
    public static String reverseVowels(String s) {
        char[] chars = s.toCharArray();
        String vowel = "aeiouAEIOU";
        int i=0, j=chars.length-1;

        while(i<j) {
            while(i < j && !vowel.contains(chars[i] + ""))
                i++;

            while(i < j && !vowel.contains(chars[j] + ""))
                j--;

            if(vowel.contains(chars[i] + "") && vowel.contains(chars[j] + "")) {
                char c = chars[i];
                chars[i] = chars[j];
                chars[j] = c;
                i++;
                j--;
            }
        }

        return new String(chars);
    }
    public static void main(String[] args) {
        String s1 = "leetcode";
        System.out.println(reverseVowels(s1));
    }
}
