import java.math.BigInteger;

public class Smallest_Palindromic_Rearrangement_II {
    public static String smallestPalindrome(String s, int k) {
        if(s.length() == 1 && k == 1) return s;
        int[] freq = new int[26];
        int charCount = 0;

        for(char c : s.toCharArray()) {
            freq[c - 'a']++;
            if (freq[c - 'a'] == 1)
                charCount++;
        }

        StringBuilder prefix = new StringBuilder();
        char mid = '?';
        int ind = 0;
        k = k%charCount;

        for(int i=0;i<26;i++) {
            if (freq[i] == 0) continue;

            if(freq[i] % 2 == 1) {
                mid = (char) ('a'+i);
            }

            if(freq[i] > 1 && --k == 0)
                ind = i;

            if(k > 0) continue;

            int count = freq[i] / 2;
            while(count-- > 0) {
                prefix.append((char)(i+'a'));
            }

            freq[i] = 0;
        }

        if(prefix.isEmpty()) return "";

        for(int i=0;i<ind;i++) {
            if (freq[i] == 0) continue;

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
    public static String smallestPalindrome2(String s, int k) {
        int n = s.length();
        if (n == 1)
            return k == 1 ? s : "";

        int half = n/2;
        int[] freq = new int[26];
        for (int i = 0; i < half; i++) {
            freq[s.charAt(i) - 'a']++;
        }

        // 1) Compute perm = (half)! / (freq[0]! * ... * freq[25]!)
        BigInteger perms = BigInteger.ONE;
        int sum = 0;
        for (int c = 0; c < 26; c++) {
            int f = freq[c];
            for (int j = 1; j <= f; j++) {
                perms = perms.multiply(BigInteger.valueOf(sum + j)).divide(BigInteger.valueOf(j));
            }
            sum += f;
        }

        BigInteger rank = BigInteger.valueOf(k - 1);
        StringBuilder halfStr = new StringBuilder(half);

        for (int rem = half; rem > 0; rem--) {
            for (int c = 0; c < 26; c++) {
                if (freq[c] == 0) continue;
                // blockSize = perms * freq[c] / rem
                BigInteger blockSize = perms.multiply(BigInteger.valueOf(freq[c])).divide(BigInteger.valueOf(rem));

                if (rank.compareTo(blockSize) < 0) {
                    halfStr.append((char)('a' + c));
                    perms = blockSize;
                    freq[c]--;
                    break;
                } else {
                    rank = rank.subtract(blockSize);
                }
            }
        }

        // assemble full palindrome
        String left = halfStr.toString();
        String right = new StringBuilder(left).reverse().toString();
        return left.length() < n/2 ? "" : left + (n % 2 == 1 ? s.charAt(half) : "") + right;
    }
    public static void main(String[] args) {
        System.out.println(smallestPalindrome2("nyggyn", 2));
    }
}
