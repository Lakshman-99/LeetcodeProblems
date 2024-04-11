//  344. Reverse String
//
//  https://leetcode.com/problems/reverse-string/

import java.util.Arrays;

public class Reverse_String {
    public static void reverseString(char[] s) {
        int n = s.length;

        for(int i=0, j=n-1;i<n/2;i++, j--) {
            char temp = s[i];
            s[i] = s[j];
            s[j] = temp;
        }
    }
    public static void main(String[] args) {
        char[] input = "hello".toCharArray();
        reverseString(input);
        System.out.println(Arrays.toString(input));
    }
}
