public class Smallest_Palindromic_Rearrangement_I {
    public static String smallestPalindrome(String s) {
        if(s == null || s.length() <= 2) return s;
        int[] freq = new int[26];

        for(char c : s.toCharArray())
            freq[c-'a']++;

        StringBuilder prefix = new StringBuilder();
        char mid = '?';

        for(int i=0;i<26;i++) {
            if(freq[i] == 0) continue;

            if(freq[i] % 2 == 1) {
                mid = (char) ('a'+i);
            }

            int count = freq[i] / 2;
            while(count-- > 0) {
                prefix.append((char)(i+'a'));
            }
        }

        String result = prefix.toString();

        if(mid != '?')
            result += mid;

        result += prefix.reverse().toString();

        return result;
    }
    public static void main(String[] args) {
        System.out.println(smallestPalindrome("bazab"));
    }
}
