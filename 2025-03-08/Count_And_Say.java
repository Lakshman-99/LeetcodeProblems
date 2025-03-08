package practice;

public class Count_And_Say {
    public static String countAndSay(int n) {
        if(n == 1) return "1";

        String root = countAndSay(n-1);
        StringBuilder sb = new StringBuilder();

        int count = 1;
        for(int i=1;i<root.length();i++) {
            if(root.charAt(i) == root.charAt(i-1)) {
                count++;
            }
            else {
                sb.append(count).append(root.charAt(i-1));
                count = 1;
            }
        }
        sb.append(count).append(root.charAt(root.length()-1));

        return sb.toString();
    }
    public static void main(String[] args) {
        System.out.println(countAndSay(4));
    }
}
