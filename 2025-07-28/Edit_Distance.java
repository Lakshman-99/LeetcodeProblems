package patterns.dynamic_programming;

public class Edit_Distance {
    public static int minDistance(String word1, String word2) {
        int[][] cache = new int[word1.length()+1][word2.length()+1];

        for(int i=0;i<=word1.length();i++)
            cache[i][0] = i;

        for(int i=0;i<=word2.length();i++)
            cache[0][i] = i;

        for(int i=1;i<=word1.length();i++) {
            for(int j=1;j<=word2.length();j++) {
                if(word1.charAt(i-1) == word2.charAt(j-1))
                    cache[i][j] = cache[i-1][j-1];
                else
                    cache[i][j] = 1 + Math.min(cache[i-1][j-1], Math.min(cache[i-1][j], cache[i][j-1]));
            }
        }

        return cache[word1.length()][word2.length()];
    }
    public static void main(String[] args) {
        System.out.println(minDistance("horse", "ros"));
    }
}
