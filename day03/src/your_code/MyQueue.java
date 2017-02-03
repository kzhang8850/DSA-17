package your_code;

import ADTs.QueueADT;

import java.util.LinkedList;

/**
 * An implementation of the Queue interface.
 */


public class MyQueue implements QueueADT<Integer> {

    LinkedList<Integer> queue = new LinkedList<Integer>();
    @Override
    public void enqueue(Integer item) {
        queue.addLast(item);
    }

    @Override
    public Integer dequeue() {
        int popped = queue.removeFirst();
        return popped;
    }

    @Override
    public boolean isEmpty() {
        return queue.size() == 0;
    }

    @Override
    public Integer front() {
        int front = queue.get(0);
        return front;
    }
}