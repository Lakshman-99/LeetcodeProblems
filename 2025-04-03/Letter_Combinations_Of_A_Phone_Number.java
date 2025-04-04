package amazon;

import java.util.*;

public class Letter_Combinations_Of_A_Phone_Number {
    public static void getCombinations(int cur, StringBuilder comb, String[] strs, List<String> ans) {
        if(cur == strs.length) {
            ans.add(comb.toString());
            return;
        }

        for(char c : strs[cur].toCharArray()) {
            comb.append(c);
            getCombinations(cur+1, comb, strs, ans);
            comb.deleteCharAt(comb.length()-1);
        }
    }
    public static List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        if(digits == null || digits.isEmpty()) return ans;

        String[] phone_map = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        String[] arr = new String[digits.length()];

        for(int i=0;i<digits.length();i++) {
            arr[i] = phone_map[digits.charAt(i)-'2'];
        }

        getCombinations(0, new StringBuilder(), arr, ans);
        return ans;
    }
    public static void main(String[] args) {
        String digits = "9229";
        System.out.println(letterCombinations(digits));
    }
}
