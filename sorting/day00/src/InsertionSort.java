
public class InsertionSort extends SortAlgorithm {
    /**
     * Use the insertion sort algorithm to sort the array
     *
     * Best-case runtime: n
     * Worst-case runtime: n^2
     * Average-case runtime: n^2
     *
     * Space-complexity: n
     */
    @Override
    public int[] sort(int[] array) {

        for(int i = 1; i < array.length; i++){
            if(array[i] < array[i-1]){
                int j = i;
                int currentValue = array[i];
                while(j > 0 && array[j-1] > currentValue){
                    array[j] = array[j-1];
                    j--;
                }
                array[j] = currentValue;
            }

        }
        return array;
    }

    public static void main(String args[]){
        InsertionSort insertion = new InsertionSort();
        int[] temp = {54,26,93,17,77,31,44,55,20};
        int[] alist = insertion.sort(temp);
        for(int item: alist){
            System.out.println(item);
        }
        System.out.println((6+7)/2);
    }
}



