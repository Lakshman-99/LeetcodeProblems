package patterns.two_pointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Shortest_Distance_To_A_Character {
    public static int[] shortestToChar(String s, char c) {
        int[] distances = new int[s.length()];
        List<Integer> cIndices = new ArrayList<>();

        for(int i=0;i<s.length();i++) {
            if(s.charAt(i) == c)
                cIndices.add(i);
        }

        int curIndex = 0;
        for(int i=0;i<s.length();i++) {
            if(s.charAt(i) == c) {
                curIndex++;
            }

            if(curIndex > 0 && curIndex < cIndices.size())
                distances[i] = Math.min(Math.abs(i-cIndices.get(curIndex)), Math.abs(i-cIndices.get(curIndex-1)));
            else if(curIndex >= cIndices.size()) {
                distances[i] = Math.abs(i-cIndices.get(curIndex-1));
            }
            else {
                distances[i] = Math.abs(i-cIndices.get(curIndex));
            }
        }

        return distances;
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(shortestToChar("loveleetcode", 'e')));
    }
}
