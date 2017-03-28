import java.util.LinkedList;
import java.util.Queue;

public class ReviewProblem {

    public static int minimumLengthSubArray(int[] A, int desiredSum) {
        int minlength = A.length + 1;
        Queue<Integer> subarray = new LinkedList<>();
        int sum = 0;
        int index = 0;

        while(index < A.length){
            if(subarray.isEmpty() || sum < desiredSum) {
                int item = A[index];
                subarray.offer(item);
                sum += item;
                index++;
                if(index == A.length) {
                    while (sum >= desiredSum) {
                        int length = subarray.size();
                        if (length < minlength) {
                            minlength = length;
                        }
                        int dropped = subarray.poll();
                        sum -= dropped;
                    }
                }
            }
            else {

                while (sum >= desiredSum) {
                    int length = subarray.size();
                    if (length < minlength) {
                        minlength = length;
                    }
                    int dropped = subarray.poll();
                    sum -= dropped;


                }
            }
        }

        if(minlength == A.length + 1){
            return 0;
        }
        else{
            return minlength;
        }

    }

}
