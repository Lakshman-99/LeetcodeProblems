import java.math.BigInteger;
import java.util.*;

public class Smallest_Palindromic_Rearrangement_II {
    private static final int MAX = 100;
    private static final BigInteger[] FACT = new BigInteger[MAX + 1];

    static {
        FACT[0] = BigInteger.ONE;
        for (int i = 1; i <= MAX; i++) {
            FACT[i] = FACT[i - 1].multiply(BigInteger.valueOf(i));
        }
    }

    public static String smallestPalindrome(String s, int k) {
        int[] freq = new int[26];
        for (char c : s.toCharArray())
            freq[c - 'a']++;

        int odd = 0;
        char midChar = 0;
        for (int i = 0; i < 26; i++) {
            if (freq[i] % 2 != 0) {
                odd++;
                midChar = (char) (i + 'a');
            }
        }

        if (odd > 1) return "";

        // Build half frequencies
        int[] halfFreq = new int[26];
        int total = 0;
        for (int i = 0; i < 26; i++) {
            halfFreq[i] = freq[i] / 2;
            total += halfFreq[i];
        }

        BigInteger totalPerms = countPermutations(halfFreq, total);
        BigInteger kBig = BigInteger.valueOf(k);
        if (kBig.compareTo(totalPerms) > 0) return "";

        StringBuilder result = new StringBuilder();
        kBig = kBig.subtract(BigInteger.ONE); // zero-based

        while (result.length() < total) {
            for (int i = 0; i < 26; i++) {
                if (halfFreq[i] == 0) continue;

                halfFreq[i]--;
                BigInteger perms = countPermutations(halfFreq, total - result.length() - 1);

                if (kBig.compareTo(perms) < 0) {
                    result.append((char) (i + 'a'));
                    break;
                } else {
                    kBig = kBig.subtract(perms);
                    halfFreq[i]++;
                }
            }
        }

        String half = result.toString();
        String reverse = new StringBuilder(half).reverse().toString();
        return midChar == 0 ? half + reverse : half + midChar + reverse;
    }

    private static BigInteger countPermutations(int[] freq, int total) {
        BigInteger num = FACT[total];
        for (int f : freq) {
            if (f > 1)
                num = num.divide(FACT[f]);
        }
        return num;
    }

    public static void main(String[] args) {
        String s = "ycnypoidimbrvasctjkkwwkkjtcsavrbmidiopyncy";
        int k = 32993;
        System.out.println(smallestPalindrome(s, k));
    }

}
