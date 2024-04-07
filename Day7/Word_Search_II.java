//  212. Word Search II
//
//  https://leetcode.com/problems/word-search-ii/description/

import java.util.*;

public class Word_Search_II {
    public static boolean[][] visited;
    public static Set<String> words_set;
    public static void dfs(char[][] board, int i, int j, int ptr, int max, Set<String> ans, StringBuilder sb) {
        if(i>=board.length || i<0 || j>=board[0].length || j<0 || ptr>=max) return;
        if(visited[i][j]) return;

        visited[i][j] = true;
        sb.append(board[i][j]);

        if(words_set.contains(sb.toString())) {
            ans.add(sb.toString());
        }

        dfs(board, i+1, j, ptr+1, max, ans, sb);
        dfs(board, i-1, j, ptr+1, max, ans, sb);
        dfs(board, i, j+1, ptr+1, max, ans, sb);
        dfs(board, i, j-1, ptr+1, max, ans, sb);

        visited[i][j] = false;
        sb.deleteCharAt(sb.length()-1);
    }
    public static List<String> findWords(char[][] board, String[] words) {
        int n = board[0].length;
        int m = board.length;

        visited = new boolean[m][n];
        words_set = new HashSet<>();

        int max_length = 0;
        for(String word: words) {
            words_set.add(word);
            max_length = Math.max(max_length, word.length());
        }

        Set<String> set = new HashSet<>();

        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                dfs(board, i, j, 0, max_length, set, new StringBuilder());
            }
        }

        return new ArrayList<>(set);
    }
    public static void main(String[] args) {
        char[][] board = new char[][]{
                {'o','a','a','n'},
                {'e','t','a','e'},
                {'i','h','k','r'},
                {'i','f','l','v'}
        };
        String[] words = new String[]{"oath","pea","eat","rain"};
        List<String> ans = findWords(board, words);

        System.out.println(Arrays.toString(ans.toArray()));
    }
}
