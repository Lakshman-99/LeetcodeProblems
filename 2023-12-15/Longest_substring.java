import java.util.*;

public class Longest_substring {
    public static int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> charIndex = new HashMap<>();
        int start = 0;
        int maxLength = 0;

        for (int end = 0; end < s.length(); end++) {
            char currentChar = s.charAt(end);

            if (charIndex.containsKey(currentChar) && charIndex.get(currentChar) >= start) {
                start = charIndex.get(currentChar) + 1;
            }

            charIndex.put(currentChar, end);
            int currentLength = end - start + 1;
            maxLength = Math.max(maxLength, currentLength);
        }

        return maxLength;
    }

    public static void main(String[] args) {
        int arr = lengthOfLongestSubstring("dvdf");

        System.out.print(arr + " ");
    }
}
