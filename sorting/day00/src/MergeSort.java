import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;


public class MergeSort extends SortAlgorithm {

    private static final int INSERTION_THRESHOLD = 10;

    /**
     * This is the recursive step in which you split the array up into
     * a left and a right portion, sort them, and then merge them together.
     *
     * Best-case runtime: nlogn
     * Worst-case runtime: nlogn
     * Average-case runtime: nlogn
     *
     * Space-complexity: nlogn
     */
    @Override
    public int[] sort(int[] array) {
        if(array.length <= 1){
            return array;
        }
        else{
            int[] leftarray = sort(Arrays.copyOfRange(array, 0, array.length/2));
            int[] rightarray = sort(Arrays.copyOfRange(array, array.length/2, array.length));
            int[] merged = merge(leftarray, rightarray);

            return merged;
        }
    }

    /**
     * Given two sorted arrays a and b, return a new sorted array containing
     * all elements in a and b. A test for this method is provided in `SortTest.java`
     * Use Insertion Sort if the length of the array is <= INSERTION_THRESHOLD
     */
    public int[] merge(int[] a, int[] b) {
        int[] ab = new int[a.length + b.length];

        if ((a.length + b.length) > INSERTION_THRESHOLD) {
            System.arraycopy(a, 0, ab, 0, a.length);
            System.arraycopy(b, 0, ab, a.length, b.length);
            InsertionSort sorter = new InsertionSort();
            int[] result = sorter.sort(ab);
            return result;
        } else {
            int aindex = 0;
            int bindex = 0;
            int index = 0;
            while (aindex < a.length && bindex < b.length) {
                if (a[aindex] < b[bindex]) {
                    ab[index] = a[aindex];
                    aindex++;

                } else {
                    ab[index] = b[bindex];
                    bindex++;
                }
                index ++;
            }
            if (aindex == a.length) {
                while (bindex < b.length) {
                    ab[index] = b[bindex];
                    bindex++;
                    index ++;
                }
            }
            else if (bindex == b.length) {
                while (aindex < a.length){
                    ab[index] = a[aindex];
                    aindex++;
                    index ++;
                }
            }
            return ab;
        }

    }
}
