package patterns.two_pointers;

public class Three_Sum_With_Multiplicity {
    private static int MOD = (int) (1e9 + 7);
    public static int threeSumMulti(int[] arr, int target) {
        long result = 0;
        int n = arr.length;

        for(int i=0;i<n-2;i++) {
            int left = i+1;
            int right = n-1;

            while(left < right) {
                int sum = arr[i]+arr[left]+arr[right];
                if(sum == target) {
                    result = (result+1)%MOD;
                    left++;
                }
                else if(sum < target) {
                    left++;
                }
                else {
                    right--;
                }
            }
        }
        return (int) result;
    }
    public static void main(String[] args) {
        int[] arr = {1,1,2,2,3,3,4,4,5,5};
        System.out.println(threeSumMulti(arr, 8));
    }
}
