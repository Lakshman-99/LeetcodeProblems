public class K_th_Element_Of_Two_Arrays {
    public static int kthElement(int a[], int b[], int k) {
        int s1=0, s2=0, e1=a.length-1, e2=b.length-1;
        if(e2 > e1) return kthElement(b, a, k);

        int low = Math.max(0, k);
        while(s1<e1 && s2<e2) {
            int mid1 = (s1 + e1) / 2;
            int mid2 = (s2 + e2) / 2;

            int exp_k = mid1+mid2;

            if(exp_k == k) {
                return Math.min(a[mid1], b[mid2]);
            }

            if(k < exp_k) {
                e1 = mid1-1;
                e2 = mid2-1;
            }
            else {
                s1 = mid1+1;
                s2 = mid2+1;
            }
        }
        return Math.min(a[s1], b[s2]);
    }
    public static void main(String[] args) {
        int[] arr = {2, 3, 6, 7, 9};
        int[] arr2 = {1, 4, 8, 10};

        System.out.println(kthElement(arr, arr2, 5));
    }
}
