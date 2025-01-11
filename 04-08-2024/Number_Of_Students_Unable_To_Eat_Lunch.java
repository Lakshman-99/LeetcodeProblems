//  1700. Number of Students Unable to Eat Lunch
//
//  https://leetcode.com/problems/number-of-students-unable-to-eat-lunch/description
public class Number_Of_Students_Unable_To_Eat_Lunch {
    public static int countStudents(int[] students, int[] sandwiches) {
        int[] fre1 = new int[2];

        for(int num : students) {
            fre1[num]++;
        }
        for(int i=0;i<sandwiches.length;i++) {
            if(fre1[sandwiches[i]]-- == 0) {
                return sandwiches.length-i;
            }
        }

        return 0;
    }
    public static void main(String[] args) {
        int[] std = new int[]{0,0,1,1,0,0,0,0,1,0,0,1,1,0,1,1};
        int[] snd = new int[]{1,0,0,0,0,0,0,1,0,0,1,0,1,1,1,0};

        System.out.println(countStudents(std, snd));
    }
}
