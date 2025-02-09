package practice;

public class Reverse_Words {
    public static String reverseWords(String s) {
        StringBuilder ans = new StringBuilder();
        int i = s.length() - 1;

        while(i >= 0) {
            if(s.charAt(i) == ' ') {
                i--;
                continue;
            }
            int end = i;
            while(i >= 0 && s.charAt(i) != ' ') i--;

            ans.append(s, i+1, end+1).append(" ");
        }

        return ans.toString().trim();
    }
    public static void main(String[] args) {
        String s = "the sky is blue";
        System.out.println(reverseWords(s));
    }
}
