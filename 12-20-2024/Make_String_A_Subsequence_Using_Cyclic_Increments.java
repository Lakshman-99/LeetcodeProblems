// 2825. Make String a Subsequence Using Cyclic Increments

// https://leetcode.com/problems/make-string-a-subsequence-using-cyclic-increments/description

public class Make_String_A_Subsequence_Using_Cyclic_Increments {
    public static boolean canMakeSubsequence(String str1, String str2) {
        int ind = 0, m = str2.length();

        for(char c : str1.toCharArray()) {
            if(ind < m && (str2.charAt(ind) - c + 26) % 26 <= 1) {
                ind++;
            }
        }

        return ind == m;
    }

    public static void main(String[] args) {
        String s1 = "abc";
        String s2 = "ad";

        System.out.println(canMakeSubsequence(s1, s2));
    }
}
