package amazon;

public class Max_Chunks_To_Make_Sorted {
    public static int maxChunksToSorted(int[] arr) {
        int result=0, expSum=0, sum=0;

        for(int i=0;i<arr.length;i++) {
            expSum += i;
            sum += arr[i];

            if(expSum == sum)
                result++;
        }

        return result;
    }
    public static void main(String[] args) {
        int[] arr = {2,0,1};
        System.out.println(maxChunksToSorted(arr));
    }
}
