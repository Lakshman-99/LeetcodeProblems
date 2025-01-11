//  151. Reverse Words in a String
//
//  https://leetcode.com/problems/reverse-words-in-a-string/description/

public class Reverse_Words_In_A_String {
    public static String reverseWords(String s) {
        String[] arr=s.trim().split("\\s+");
        int i = 0, j = arr.length-1;

        while(i<j) {
            String temp = arr[i];
            arr[i++] = arr[j];
            arr[j--] = temp;
        }

        return String.join(" ", arr);
    }

    public static void main(String[] args) {
        String str = "the sky is blue";
        System.out.println(reverseWords(str));
    }
}
