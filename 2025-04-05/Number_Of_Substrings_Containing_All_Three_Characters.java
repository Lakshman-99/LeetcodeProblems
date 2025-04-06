package amazon;

public class Number_Of_Substrings_Containing_All_Three_Characters {
    public static int numberOfSubstrings(String s) {
        int[] lastSeen = {-1,-1,-1};
        int count = 0, i = 0;

        for(char c : s.toCharArray()) {
            lastSeen[c-'a'] = i++;

            if(lastSeen[0] != -1 && lastSeen[1] != -1 && lastSeen[2] != -1) {
                count += (1 + Math.min(lastSeen[0], Math.min(lastSeen[1], lastSeen[2])));
            }
        }

        return count;
    }
    public static void main(String[] args) {
        System.out.println(numberOfSubstrings("abcabc"));
    }
}
