import java.util.ArrayList;
import java.util.List;

public class Word_Subsets {
    public static List<String> wordSubsets(String[] words1, String[] words2) {
        List<String> ans = new ArrayList<>();
        int[] tempFre;
        int[] fre = new int[150];

        for(String word : words2) {
            tempFre = new int[150];
            for(char c : word.toCharArray()) {
                tempFre[c]++;
            }
            for(int i=0;i<150;i++) {
                fre[i] = Math.max(fre[i], tempFre[i]);
            }
        }

        for(String word : words1) {
            int[] freq = new int[150];
            for(char c : word.toCharArray()) {
                freq[c]++;
            }
            int i;
            for(i=0;i<150;i++) {
                if(fre[i] > freq[i])
                    break;
            }

            if(i == 150) {
                ans.add(word);
            }
        }

        return ans;
    }
    public static void main(String[] args) {
        String[] words1 = new String[]{"amazon","apple","facebook","google","leetcode"};
        String[] words2 = new String[]{"lo", "eo"};

        System.out.println(wordSubsets(words1, words2));
    }
}
