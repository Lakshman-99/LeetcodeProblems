package amazon;

public class String_Compression {
    public static int compress(char[] chars) {
        int count = 1, length = 0;

        for(int i=0;i<chars.length;i++) {
            if(i+1 == chars.length || chars[i] != chars[i+1]) {
                chars[length++] = chars[i];
                if(count != 1) {
                    String digit = count+"";
                    for(int j=0;j<digit.length();j++) {
                        chars[length++] = digit.charAt(j);
                    }
                }
                count = 1;
            }
            else {
                count++;
            }
        }

        return length;
    }
    public static void main(String[] args) {
        char[] ch = {'a','b','b','b','b','b','b','b','b','b','b','b','b'};
        System.out.println(compress(ch));
        System.out.println(ch);
    }
}
