// 1768. Merge Strings Alternately

// https://leetcode.com/problems/merge-strings-alternately/description

public class Merge_Strings_Alternately {
    public static String mergeAlternately(String word1, String word2) {
        StringBuilder ans = new StringBuilder();
        int i=0,j=0,n=word1.length(),m=word2.length();

        while(i<n && j<m)
            ans.append(word1.charAt(i++)).append(word2.charAt(j++));

        while(i<n)
            ans.append(word1.charAt(i++));

        while(j<m)
            ans.append(word2.charAt(j++));

        return ans.toString();
    }
    public static void main(String[] args) {
        String s1 = "abc";
        String s2 = "pqr";
        System.out.println(mergeAlternately(s1, s2));
    }
}
