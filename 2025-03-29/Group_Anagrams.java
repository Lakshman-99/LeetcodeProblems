package amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Group_Anagrams {
    public static List<List<String>> groupAnagrams(String[] strs) {
        if(strs == null || strs.length == 0) return new ArrayList<>();

        HashMap<String, ArrayList<String>> map = new HashMap<>();

        for(String s:strs) {
            char[] arr = s.toCharArray();
            Arrays.sort(arr);
            String sorted = new String(arr);

            map.computeIfAbsent(sorted, k->new ArrayList<>()).add(s);
        }

        return new ArrayList<>(map.values());
    }
    public static void main(String[] args) {
        String[] str = {"eat","tea","tan","ate","nat","bat"};
        System.out.println(groupAnagrams(str));
    }
}
