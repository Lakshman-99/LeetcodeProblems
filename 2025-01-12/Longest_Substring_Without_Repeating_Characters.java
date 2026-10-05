// 3. Longest Substring Without Repeating Characters

// https://leetcode.com/problems/longest-substring-without-repeating-characters/description

import java.util.HashMap;

public class Longest_Substring_Without_Repeating_Characters {
    public static int lengthOfLongestSubstring(String s) {
        int ans = 0, str = 0;
        HashMap<Character, Integer> map = new HashMap<>();

        for(int i=0;i<s.length();i++) {
            char c = s.charAt(i);

            if(map.containsKey(c) && map.get(c) >= str) {
                str = map.get(c) + 1;
            }
            map.put(c, i);

            ans = Math.max(ans, i - str + 1);
        }

        return ans;
    }
    public static void main(String[] args) {
        String s = "aab";
        System.out.println(lengthOfLongestSubstring(s));
    }
}
