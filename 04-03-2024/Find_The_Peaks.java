//  2951. Find the Peaks
//
//  https://leetcode.com/problems/find-the-peaks/description/

import java.util.*;

public class Find_The_Peaks {
    public static List<Integer> findPeaks(int[] mountain) {
        List<Integer> ans = new ArrayList<>();
        for(int i=1;i<mountain.length-1;i++) {
            if(mountain[i] > mountain[i+1] && mountain[i]>mountain[i-1]) {
                ans.add(mountain[i]);
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] arr = new int[]{4,1,1,3,2,1,2};
        List<Integer> ans = findPeaks(arr);
        System.out.println(ans.toString());
    }
}
