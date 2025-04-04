package amazon;

import java.util.*;

public class Analyze_User_Website_Visit_Pattern {
    public static class Node {
        String user;
        String site;
        int ts;
        public Node(String user, int ts, String site) {
            this.user = user;
            this.ts = ts;
            this.site = site;
        }
    }
    public static List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {
        int n = username.length;
        HashMap<String, ArrayList<Node>> map = new HashMap<>();
        HashMap<String, Integer> cnt = new HashMap<>();

        for(int i=0;i<n;i++) {
            Node node = new Node(username[i], timestamp[i], website[i]);
            map.computeIfAbsent(username[i], k->new ArrayList<>()).add(node);
        }

        for(String key : map.keySet()) {
            ArrayList<Node> data = map.get(key);
            int m = data.size();

            if(m < 3) continue;

            data.sort((a, b) -> Integer.compare(a.ts, b.ts));
            Set<String> set = new HashSet<>();
            for(int i=0;i<m-2;i++) {
                for(int j=i+1;j<m-1;j++) {
                    for(int k=j+1;k<m;k++) {
                        set.add(data.get(i).site + "," + data.get(j).site + "," + data.get(k).site);
                    }
                }
            }

            for(String s : set) {
                cnt.put(s, cnt.getOrDefault(s, 0) + 1);
            }
        }

        int max = 0;
        String pattern = "";

        for(String key : cnt.keySet()) {
            if(max < cnt.get(key) || (max == cnt.get(key) && key.compareTo(pattern) < 0)) {
                max = cnt.get(key);
                pattern = key;
            }
        }

        return new ArrayList<>(Arrays.asList(pattern.split(",")));
    }
    public static void main(String[] args) {
        String[] user = {"joe","joe","joe","james","james","james","james","mary","mary","mary"};
        int[] time = {1,2,3,4,5,6,7,8,9,10};
        String[] site = {"home","about","career","home","cart","maps","home","home","about","career"};

        System.out.println(mostVisitedPattern(user, time, site));
    }
}
