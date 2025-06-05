package patterns.sliding_window;

import java.util.ArrayList;
import java.util.Arrays;

public class Longest_Substring_Without_Repeating_Characters {
    public static int lengthOfLongestSubstring(String s) {
        int[] freq = new int[256];
        Arrays.fill(freq, -1);
        int max = 0, start = 0;

        for(int i=0;i<s.length();i++) {
            if(freq[s.charAt(i)] >= start) {
                start = freq[s.charAt(i)] + 1;
            }
            max = Math.max(max, i - start + 1);
            freq[s.charAt(i)] = i;
        }
        return max;
    }
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("pwwke"));
    }
}
