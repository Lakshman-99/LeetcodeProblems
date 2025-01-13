import java.util.*;

public class Test2 {
    private static final int MOD = 1000000007;
        private static Integer getPass(String str) {
            long hash = 0L, i = (long) (str.length()-1);

            for(char c : str.toCharArray()) {
                if(c == '&') break;
                hash += ((long) c * (int) Math.pow(131, i--))%MOD;
            }
            return (int) hash;
        }

        public static List<Integer> authEvents(List<List<String>> events) {
            // Write your code here
            List<Integer> answer = new ArrayList<>();
            Integer curPass = 0, curUpper = 0;

            for(List<String> event : events) {
                String q = event.get(0);
                String num = event.get(1);

                if(q.equalsIgnoreCase("setpassword")) {
                    curPass = getPass(num);
                    curUpper = getPass(num + "&");
                } else {
                    Integer numm = Integer.parseInt(num);
                    if(curPass - numm  == 0) {
                        answer.add(1);
                    } else if(numm - curUpper >= 0) {
                        int diff = numm - curUpper;
                        if("QWERTYUIOPASDFGHJKLZXCVBNMwertyuioasdfghjklzxcvbnm1234567890".indexOf((char) diff) >= 0) {
                            answer.add(1);
                        } else {
                            answer.add(0);
                        }
                    } else {
                        answer.add(0);
                    }
                }

            }

            return answer;
        }
    public static void main(String[] args) {
        List<List<String>> q = Arrays.asList(
                Arrays.asList("setPassword", "000A"),
                Arrays.asList("authorize", "108738450"),
                Arrays.asList("authorize", "108738449"),
                Arrays.asList("authorize", "244736787")
        );

        System.out.println(authEvents(q));
    }
}
