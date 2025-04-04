package amazon;

public class Reorganize_String {
    public static String reorganizeString(String s) {
        int[] freq = new int[26];
        int maxFreq = 0;
        char maxChar = '#';
        for(char c : s.toCharArray()) {
            freq[c-'a']++;
            if(freq[c-'a'] > maxFreq) {
                maxFreq = freq[c-'a'];
                maxChar = c;
            }
        }

        if(maxFreq > (s.length() +1)/2) return "";

        char[] ans = new char[s.length()];
        int ind = 0;

        while(maxFreq > 0) {
            ans[ind] = maxChar;
            ind+=2;
            maxFreq--;
        }
        freq[maxChar-'a'] = 0;

        for(int i=0;i<26;i++) {
            while(freq[i] > 0) {
                if (ind >= s.length())
                    ind = 1;

                ans[ind] = (char) ('a' + i);
                ind += 2;
                freq[i]--;
            }
        }

        return new String(ans);
    }
    public static void main(String[] args) {
        String s = "vvvlo";
        System.out.println(reorganizeString(s));
    }
}
