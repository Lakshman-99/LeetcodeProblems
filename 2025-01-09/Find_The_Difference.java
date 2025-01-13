// 389. Find the Difference

// https://leetcode.com/problems/find-the-difference/description
public class Find_The_Difference {
    public static char findTheDifference(String s, String t) {
        int ans = 0;

        for(char c : s.toCharArray())
            ans ^= c;

        for(char c : t.toCharArray())
            ans ^= c;

        return (char) ans;
    }
    public static void main(String[] args) {
        String s1 = "abcd";
        String s2 = "abcde";
        System.out.println(findTheDifference(s1, s2));
    }
}
