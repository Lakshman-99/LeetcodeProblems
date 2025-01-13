import java.util.*;

class TrieNode {
    public Character c;
    HashMap<Character, TrieNode> t;
    public boolean isEnd;
    TrieNode() {
        isEnd = false;
        t = new HashMap<>();
    }
}

public class Longest_Common_Prefix {
    public static TrieNode root = new TrieNode();
    public static void insert(String word) {
        TrieNode trav = root;
        for(Character ch : word.toCharArray()) {
            trav.c = ch;
            if(trav.t.get(ch) == null) {
                trav.t.put(ch, new TrieNode());
            }
            trav = trav.t.get(ch);
        }
        trav.isEnd = true;
    }

    public static String prefix() {
        if(root.t.size() > 1) {
            return "";
        }
        StringBuilder ans = new StringBuilder();
        TrieNode tr = root;

        while(tr.t != null && tr.t.size() == 1 && !tr.isEnd) {
            ans.append(tr.c);
            tr = tr.t.get(tr.c);
        }
        return ans.toString();
    }

    public static String longestCommonPrefix(String[] strs) {
        System.out.println(Arrays.toString(strs));
        for(String word : strs) {
            if(word.isEmpty()) {
                return "";
            }
            insert(word);
        }
        return prefix();
    }

    public static void main(String[] args) {
        String ans = longestCommonPrefix(new String[]{"ab", "a"});
        System.out.println(ans);
    }
}
