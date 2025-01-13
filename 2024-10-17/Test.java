import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Test {
    public static void main(String[] args) {
        String s = "penelope lives in hawaii";

        String[] words = s.split(" ");
        
        Arrays.sort(words, new Comparator<String>() {
            @Override
            public int compare(String word1, String word2) {
                int diff1 = getVowelConsonantDifference(word1);
                int diff2 = getVowelConsonantDifference(word2);

                // Compare by absolute difference first
                int absDiff1 = Math.abs(diff1);
                int absDiff2 = Math.abs(diff2);

                if (absDiff1 != absDiff2) {
                    return Integer.compare(absDiff1, absDiff2);
                } else {
                    // If differences are the same, compare alphabetically
                    return word1.compareTo(word2);
                }
            }

            private int getVowelConsonantDifference(String word) {
                int vowels = 0;
                int consonants = 0;
                for (char c : word.toCharArray()) {
                    if (Character.isLetter(c)) {
                        if ("AEIOUaeiou".indexOf(c) >= 0) {
                            vowels++;
                        } else {
                            consonants++;
                        }
                    }
                }
                return vowels - consonants;
            }
        });
        System.out.println(Arrays.toString(words));


        // Split the string into words and process with streams
        String[] sortedWords = Arrays.stream(s.split(" "))
                .sorted(Comparator.comparingInt(Test::vowelConsonantDifference)
                        .thenComparing(String::compareTo))
                .toArray(String[]::new);

        // Print the sorted array
        System.out.println(Arrays.toString(sortedWords));
    }

    private static int vowelConsonantDifference(String word) {
        int vowels = 0;
        int consonants = 0;

        for (char c : word.toCharArray()) {
            if (Character.isLetter(c)) {
                if ("AEIOUaeiou".indexOf(c) >= 0) {
                    vowels++;
                } else {
                    consonants++;
                }
            }
        }
        return Math.abs(vowels - consonants);
    }
}
