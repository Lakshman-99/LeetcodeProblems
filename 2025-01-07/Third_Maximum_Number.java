public class Third_Maximum_Number {
    public static int thirdMax(int[] nums) {
        Integer fst=null, snd=null, trd=null;

        for(Integer num : nums) {
            if(num.equals(fst) || num.equals(snd) || num.equals(trd)) continue;
            if(fst == null || num > fst) {
                trd = snd;
                snd = fst;
                fst = num;
            } else if(snd == null || num > snd) {
                trd = snd;
                snd = num;
            } else if(trd == null || num > trd) {
                trd = num;
            }
        }

        return trd == null ? fst : trd;
    }
    public static void main(String[] args) {
        int[] arr = new int[]{2,2,3,1};
        System.out.println(thirdMax(arr));
    }
}
