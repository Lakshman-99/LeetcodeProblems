//  290. Word Pattern
//
//  https://leetcode.com/problems/word-pattern/description/

import java.util.ArrayList;
import java.util.LinkedHashMap;

public class Word_Pattern {
    public static boolean wordPattern(String pattern, String s) {
        LinkedHashMap<Character, Integer> hm = new LinkedHashMap<>();
        char[] carr = pattern.toCharArray();

        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();

        for(int i=0;i<carr.length;i++) {
            if(!hm.containsKey(carr[i]))
                hm.put(carr[i], i);
            sb1.append(hm.get(carr[i]));
        }

        LinkedHashMap<String, Integer> hm2 = new LinkedHashMap<>();
        String[] words = s.split(" ");
        for(int i=0;i<words.length;i++) {
            if(!hm2.containsKey(words[i]))
                hm2.put(words[i], i);
            sb2.append(hm2.get(words[i]));
        }

        if(hm.size() != hm2.size()) return false;

        return sb1.toString().contentEquals(sb2);
    }
    public static void main(String[] args) {
        System.out.println(wordPattern("aba", "dog cat dog"));
    }
}
