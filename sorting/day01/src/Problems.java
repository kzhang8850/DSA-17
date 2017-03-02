import java.util.*;

public class Problems {

    private static PriorityQueue<Integer> minPQ() {
        return new PriorityQueue<>(11);
    }

    private static PriorityQueue<Integer> maxPQ() {
        return new PriorityQueue<>(11, Collections.reverseOrder());
    }

    private static double getMedian(List<Integer> A) {
        double median = (double) A.get(A.size()/2);
        if (A.size() % 2 == 0)
            median = (median + A.get(A.size()/2-1))/2.0;
        return median;
    }

    // Runtime of this algorithm is O(N^2). Sad! We provide it here for testing purposes
    public static double[] runningMedianReallySlow(int[] A) {
        double[] out = new double[A.length];
        List<Integer> seen = new ArrayList<>();
        for (int i = 0; i < A.length; i++) {
            int j = 0;
            while (j < seen.size() && seen.get(j) < A[i])
                j++;
            seen.add(j, A[i]);
            out[i] = getMedian(seen);
        }
        return out;
    }


    /**
     *
     * @param inputStream an input stream of integers
     * @return the median of the stream, after each element has been added
     */
    public static double[] runningMedian(int[] inputStream) {
        double[] runningMedian = new double[inputStream.length];
        double median = 0.0;
        int difference;
        PriorityQueue<Integer> small = minPQ();
        PriorityQueue<Integer> big = maxPQ();
        for (int i = 0; i < inputStream.length; i++){
            if(small.isEmpty() && big.isEmpty()){
                big.offer(inputStream[i]);
            }
            else{
                if(inputStream[i] >= big.peek()){
                    small.offer(inputStream[i]);
                }
                else{
                    big.offer(inputStream[i]);
                }
            }

            if(big.size() == small.size()){
                median = (big.peek() + small.peek())/2.0;
                runningMedian[i] = median;
            }
            else if(big.size() > small.size()){
                difference = big.size() - small.size();
                if(difference == 1){
                    median = big.peek();
                }
                else{
                    small.offer(big.poll());
                    median = (big.peek() + small.peek())/2.0;
                }

                runningMedian[i] = median;
            }
            else{
                difference = small.size() - big.size();
                if(difference == 1){
                    median = small.peek();
                }
                else{
                    big.offer(small.poll());
                    median = (big.peek() + small.peek())/2.0;
                }

                runningMedian[i] = median;
            }

        }

        return runningMedian;
    }

    public static void main(String [] args){
        int[] in = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        double[] result = runningMedian(in);
        for(double item: result){
            System.out.println(item);
        }

    }

}
