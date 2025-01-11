import java.util.*;
public class Minimum_Number_of_Steps_to_Make_Two_Strings_Anagram {
    public static int minSteps(String s, String t) {
        int[] charCount = new int[26];

        for (char c : s.toCharArray()) {
            charCount[c - 'a']++;
        }
        for (char c : t.toCharArray()) {
            charCount[c - 'a']--;
        }
        int result = 0;
        for (int count : charCount) {
            result += Math.abs(count);
        }
        return result / 2;
    }
    public static void main(String[] args) {
        int ans = minSteps("leetcode", "practice");
        System.out.println(ans);
    }
}
