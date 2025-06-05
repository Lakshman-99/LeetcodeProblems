package patterns.sliding_window;

import java.util.*;

public class Find_All_Anagrams_In_A_String {
    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if (s.length() < p.length()) return result;

        int[] freq = new int[26];
        for (char c : p.toCharArray()) {
            freq[c - 'a']++;
        }

        int[] window = new int[26];
        int left = 0, right = 0;
        while (right < s.length()) {
            window[s.charAt(right) - 'a']++;

            if (right - left + 1 == p.length()) {
                if (Arrays.equals(freq, window)) {
                    result.add(left);
                }
                window[s.charAt(left) - 'a']--;
                left++;
            }

            right++;
        }

        return result;
    }
    public static void main(String[] args) {
        System.out.println(findAnagrams("abab", "ab"));
    }
}
