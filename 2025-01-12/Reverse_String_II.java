// 541. Reverse String II

// https://leetcode.com/problems/reverse-string-ii/description/?envType=problem-list-v2&envId=string

public class Reverse_String_II {
    public static String reverseStr(String s, int k) {
        char[] c = s.toCharArray();

        for(int i=0;i<s.length();i++) {
            int start = i;
            int end = i + k - 1 >= s.length() ? s.length() - 1 : i + k -1 ;

            while(start < end) {
                char ch = c[end];
                c[end] = c[start];
                c[start] = ch;
                start++;
                end--;
            }

            i += k + k - 1;
        }

        return new String(c);
    }
    public static void main(String[] args) {
        String s = "abc";
        System.out.println(reverseStr(s, 2));
    }
}
