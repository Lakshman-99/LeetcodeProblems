// 1455. Check If a Word Occurs As a Prefix of Any Word in a Sentence

// https://leetcode.com/problems/check-if-a-word-occurs-as-a-prefix-of-any-word-in-a-sentence/description/

public class Check_If_A_Word_Occurs_As_A_Prefix_Of_Any_Word_In_A_Sentence {
    public static int isPrefixOfWord(String sentence, String searchWord) {
        int i = 1;

        for(String word : sentence.split(" ")) {
            if(word.startsWith(searchWord))
                return i;
            i++;
        }
        return -1;
    }
    public static void main(String[] args) {
        System.out.println(isPrefixOfWord("i love eating burger", "burg"));
    }
}
