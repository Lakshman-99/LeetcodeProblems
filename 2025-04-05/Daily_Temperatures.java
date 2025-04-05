package amazon;

import java.util.Arrays;
import java.util.Stack;

public class Daily_Temperatures {
    public static int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];
        Stack<int[]> st = new Stack<>();

        for(int i=0;i<temperatures.length;i++) {
            while(!st.isEmpty() && st.peek()[0] < temperatures[i]) {
                int curInd = st.pop()[1];
                result[curInd] = i - curInd;
            }
            st.add(new int[]{temperatures[i], i});
        }

        return result;
    }
    public static void main(String[] args) {
        int[] temps = {73,74,75,71,69,72,76,73};
        System.out.println(Arrays.toString(dailyTemperatures(temps)));
    }
}
