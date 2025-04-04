package amazon;

import java.util.Arrays;
import java.util.HashMap;

public class Longest_Substring_Without_Repeating_Characters {
    public static int lengthOfLongestSubstring(String s) {
        int length=0, start=0;
        int[] lastIndex = new int[128];
        Arrays.fill(lastIndex, -1);

        for(int i=0;i<s.length();i++) {
            char c = s.charAt(i);

            if(lastIndex[c] >= start) {
                start = lastIndex[c] + 1;
            }

            length = Math.max(length, i - start + 1);
            lastIndex[c] = i;
        }

        return length;
    }
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcdabcbb"));
    }
}
