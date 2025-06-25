package patterns.two_pointers;

import java.util.ArrayList;
import java.util.List;

public class Camelcase_Matching {
    public static List<Boolean> camelMatch(String[] queries, String pattern) {
        List<Boolean> result = new ArrayList<>();

        for(String query : queries) {
            int left = 0;
            boolean flag = true;
            for(char c : query.toCharArray()) {
                if(left < pattern.length() && c == pattern.charAt(left)) left++;
                else if(c < 'a') flag = false;
            }
            result.add(left==pattern.length() && flag);
        }

        return result;
    }
    public static void main(String[] args) {
        String[] queries = {"FooBar","FooBarTest","FootBall","FrameBuffer","ForceFeedBack"};
        System.out.println(camelMatch(queries, "FoBa"));
    }
}
