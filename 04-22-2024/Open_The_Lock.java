//  752. Open the Lock
//
//  https://leetcode.com/problems/open-the-lock/description

import java.util.*;
public class Open_The_Lock {
    private static char turnLeft(char ch) {
        return (ch == '0' ? '9' : (char)(ch - 1));
    }

    private static char turnRight(char ch) {
        return (ch == '9' ? '0' : (char)(ch + 1));
    }

    private static List<String> nextSteps(String s) {
        List<String> newSteps = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            StringBuilder copy = new StringBuilder(s);
            copy.setCharAt(i, turnLeft(s.charAt(i)));
            newSteps.add(copy.toString());
            copy.setCharAt(i, turnRight(s.charAt(i)));
            newSteps.add(copy.toString());
        }
        return newSteps;
    }

    public static int openLock(String[] deadends, String target) {
        Set<String> deadendSet = new HashSet<>(Arrays.asList(deadends));
        if (deadendSet.contains("0000")) return -1;

        Set<String> visited = new HashSet<>();
        Queue<String> q = new LinkedList<>();

        q.offer("0000");
        visited.add("0000");
        int lvl = 0;

        while (!q.isEmpty()) {
            int sz = q.size();
            for (int i = 0; i < sz; i++) {
                String currCode = q.poll();

                if (currCode.equals(target)) return lvl;
                if (deadendSet.contains(currCode)) continue;

                for (String nextCode : nextSteps(currCode)) {
                    if (!visited.contains(nextCode)) {
                        q.offer(nextCode);
                        visited.add(nextCode);
                    }
                }
            }
            lvl++;
        }
        return -1;
    }
    public static void main(String[] args) {
        String[] mat = new String[]{"0201","0101","0102","1212","2002"};
        int ans = openLock(mat, "0202");
        System.out.println(ans);
    }
}
