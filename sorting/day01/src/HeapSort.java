public class HeapSort extends SortAlgorithm {
    int size;
    int[] heap;

    private int parent(int i) {
        return (i-1) / 2;
    }

    private int leftChild(int i) {
        return 2*i + 1;
    }

    private int rightChild(int i) {
        return 2 * (i + 1);
    }

    // Recursively corrects the position of element indexed i: check children, and swap with larger child if necessary.
    public void heapify(int i) {
        if(((rightChild(i) >= this.size) && (leftChild(i) >= this.size))){
            return;
        }
        else if(rightChild(i) >= this.size){
            if(this.heap[i]<this.heap[leftChild(i)]){
                swap(this.heap, i, leftChild(i));
                heapify(leftChild(i));
            }
            else{
              return;
            }
        }
        else{
            if((this.heap[i] > this.heap[leftChild(i)]) && (this.heap[i] > this.heap[rightChild(i)])){
                return;
            }
            else if(this.heap[rightChild(i)] > this.heap[leftChild(i)]){
                swap(this.heap, rightChild(i), i);
                heapify(rightChild(i));

            }
            else{
                swap(this.heap, leftChild(i), i);
                heapify(leftChild(i));

            }
        }
    }

    // Given the array, build a heap by correcting every non-leaf's position.
    public void buildHeapFrom(int[] array) {
        this.heap = array;
        this.size = array.length;
        for(int i = this.size-1; i >= 0; i--){
                heapify(i);
        }
    }

    /**
     * Best-case runtime: nlogn
     * Worst-case runtime: nlogn
     * Average-case runtime: nlogn
     *
     * Space-complexity:  n
     */
    @Override
    public int[] sort(int[] array) {
        buildHeapFrom(array);
        for (int i=size-1; i>0; i--) {
            swap(this.heap, i, 0);
            this.size --;
            heapify(0);
        }
        return heap;
    }

    public static void main(String [] args){
        int[] in = new int[]{8, 2, 9, 1, 5, 6, 3, 1, 2};
        HeapSort h = new HeapSort();
        h.buildHeapFrom(in);
        for(int item: in){
            System.out.println(item);
        }

    }
}
