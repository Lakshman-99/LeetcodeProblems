package patterns.sliding_window;

public class Longest_Repeating_Character_Replacement {
    public static int characterReplacement(String s, int k) {
        int left = 0, max = 0, maxFreq = 0;
        int[] window = new int[26];

        for(int right=0;right<s.length();right++) {
            char curChar = s.charAt(right);
            window[curChar - 'A']++;
            maxFreq = Math.max(maxFreq, window[curChar - 'A']);

            while(right-left+1-maxFreq > k) {
                window[s.charAt(left++) - 'A']--;
            }

            max = Math.max(max, right-left+1);
        }

        return max;
    }
    public static void main(String[] args) {
        System.out.println(characterReplacement("AABABBA",1));
    }
}
