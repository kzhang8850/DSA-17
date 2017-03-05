import java.util.Arrays;

public class CountingSort {

    /**
     * Use counting sort to sort positive integer array A.
     * Runtime: n+k
     *
     * k: maximum element in array A
     */
    static void countingSort(int[] A) {
        int k = 0;
        for (int i = 0; i < A.length; i++) {
            if(A[i] > k){
              k = A[i];
            }

        }
        int[] hist  = new int[k+1];
        for(int item: A){
            hist[item] += 1;
        }
        int index = 0;
        for (int i = 0; i < hist.length; i++) {
            while(hist[i] > 0){
                A[index] = i;
                hist[i] --;
                index ++;
            }
        }
    }

    public static void main(String [] args){
        int[] A = {10,9,8,5,7,5,4,3,2,2,2,1};
        countingSort(A);

        System.out.println(Arrays.toString(A));
    }

}
