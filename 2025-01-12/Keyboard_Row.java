// 500. Keyboard Row

// https://leetcode.com/problems/keyboard-row/description/?envType=problem-list-v2&envId=array

import java.util.Arrays;

public class Keyboard_Row {
    public static String[] findWords(String[] words) {
        int ans = words.length, i = 0;

        for(String word : words) {
            boolean fst = false, snd = false, trd = false;

            for(char c : word.toLowerCase().toCharArray()) {
                if("qwertyuiop".contains(c + "")) {
                    fst = true;
                    if(snd || trd) {
                        ans--;
                        words[i] = "/";
                        break;
                    }
                }
                else if("asdfghjkl".contains(c + "")) {
                    snd = true;
                    if(fst || trd) {
                        ans--;
                        words[i] = "/";
                        break;
                    }
                }
                else {
                    trd = true;
                    if(snd || fst) {
                        ans--;
                        words[i] = "/";
                        break;
                    }
                }
            }
            i++;
        }

        String[] ansW = new String[ans];
        i = 0;
        for (String word : words) {
            if (!word.equals("/"))
                ansW[i++] = word;
        }

        return ansW;
    }
    public static void main(String[] args) {
        String[] words = {"adsdf","sfd"};
        System.out.println(Arrays.toString(findWords(words)));
    }
}
