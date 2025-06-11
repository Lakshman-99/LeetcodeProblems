package patterns.two_pointers;

import java.util.*;

public class Partition_Labels {
    public static List<Integer> partitionLabels(String s) {
        int[] last = new int[26];
        for(int i=0;i<s.length();i++) {
            last[s.charAt(i)-'a'] = i;
        }

        List<Integer> partitions = new ArrayList<>();
        int start = 0, end = 0;
        for(int i=0;i<s.length();i++) {
            end = Math.max(end, last[s.charAt(i)-'a']);

            if(i == end) {
                partitions.add(i - start + 1);
                start = i+1;
            }
        }


        return partitions;
    }
    public static void main(String[] args) {
        System.out.println(partitionLabels("ababcbacadefegdehijhklij"));
    }
}
