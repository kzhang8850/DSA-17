package your_code;

import java.util.LinkedList;

/**
 * An implementation of a priority Queue
 */
public class MyPriorityQueue {

    LinkedList<Integer> pqueue = new LinkedList<Integer>();

    public void enqueue(int item) {
        pqueue.addLast(item);
    }

    /**
     * Return and remove the largest item on the queue.
     */
    public int dequeueMax() {
        int maxElem = 0;
        int index = 0;
        int maxIndex = 0;
        for(int item: pqueue) {
            if (item > maxElem) {
                maxElem = item;
                maxIndex = index;
            }
            index++;
        }


        pqueue.remove(maxIndex);
        return maxElem;
    }

}