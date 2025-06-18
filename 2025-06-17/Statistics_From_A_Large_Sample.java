package patterns.two_pointers;

import java.util.Arrays;

public class Statistics_From_A_Large_Sample {
    public static double[] sampleStats(int[] count) {
        if(count == null || count.length == 0) return new double[]{0,0,0,0,0};

        int minimum = Integer.MAX_VALUE, maximum = Integer.MIN_VALUE;
        double mean = 0, samples = 0, mode = 0, median = 0;
        long total = 0;

        for(int i=0;i<count.length;i++) {
            int freq = count[i];

            if(freq == 0)
                continue;

            if(minimum > i) {
                minimum = i;
            }
            if(freq > count[(int) mode]) {
                mode = i;
            }

            maximum = i;
            total += (long) freq * i;
            samples += freq;
        }
        mean = total / samples;

        if (samples == 1) median = minimum;
        int m1 = (int) ((samples + 1) / 2), m2 = (int) (samples / 2 + 1);

        for(int i=0, cnt=0;samples>1 && i<256;i++) {
            if(cnt < m1 && cnt + count[i] >= m1)
                median += i / 2.0d;
            if(cnt < m2 && cnt + count[i] >= m2)
                median += i / 2.0d;

            cnt += count[i];
        }

        return new double[]{minimum, maximum, mean, median, mode};
    }
    public static void main(String[] args) {
        int[] arr = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,3510,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,6718,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,27870,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,35,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,26256,0,0,0,0,9586565,0,0,0,0,0,0,0,2333,0,0,0,0};
        System.out.println(Arrays.toString(sampleStats(arr)));
    }
}
