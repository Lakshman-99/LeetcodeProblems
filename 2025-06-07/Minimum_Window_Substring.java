package patterns.sliding_window;

public class Minimum_Window_Substring {
    public static String minWindow(String s, String t) {
        int[] tFreq = new int[128];
        for(char c : t.toCharArray()) {
            tFreq[c]++;
        }

        int[] window = new int[128];
        int left = 0, minLen = Integer.MAX_VALUE, minLeft = 0;
        int reqChar = t.length();

        for(int right=0;right<s.length();right++) {
            char cr = s.charAt(right);
            window[cr]++;
            if(tFreq[cr] != 0 && window[cr] <= tFreq[cr]) {
                reqChar--;
            }

            while(reqChar == 0) {
                if(right-left+1 < minLen) {
                    minLen = right-left+1;
                    minLeft = left;
                }

                char cl = s.charAt(left);
                window[cl]--;
                if(tFreq[cl] != 0 && window[cl] < tFreq[cl]) {
                    reqChar++;
                }
                left++;
            }
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(minLeft, minLeft+minLen);
    }
    public static void main(String[] args) {
        System.out.println(minWindow("ADOBECODEBANC", "ABC"));
    }
}
