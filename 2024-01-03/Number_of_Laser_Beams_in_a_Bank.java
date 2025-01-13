public class Number_of_Laser_Beams_in_a_Bank {
    public static int numberOfBeams(String[] bank) {
        int preCount = 0;
        int curCount = 0;
        int ans = 0;

        for(String str : bank) {
            curCount = 0;
            for(Character c : str.toCharArray()) {
                if(c == '1') {
                    curCount++;
                }
            }

            if(curCount != 0) {
                ans = ans+preCount*curCount;
                preCount = curCount;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int ans = numberOfBeams(new String[]{"011001","000000","010100","001000"});
        System.out.println(ans);
    }
}
