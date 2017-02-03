package your_code;

import ADTs.StackADT;

import java.util.ArrayList;

/**
 * An implementation of the Stack interface.
 */
public class MyStack implements StackADT<Integer> {

    ArrayList<Integer> stack = new ArrayList<Integer>();
    ArrayList<Integer> maxStack = new ArrayList<Integer>();
    int maxElem = 0;

    @Override
    public void push(Integer e) {
        stack.add(e);
        if(maxElem == 0){
            maxStack.add(e);
            maxElem  = e;

        }
        else{
            if(e > maxElem){
                maxElem = e;
                maxStack.add(e);
            }
            else{
                maxStack.add(maxElem);
            }
        }
    }

    @Override
    public Integer pop() {
        int popped = peek();
        stack.remove(stack.size()-1);
        maxStack.remove(maxStack.size()-1);
        if(maxStack.size() == 0){
            maxElem = 0;
        }
        else if(maxStack.get(maxStack.size()-1) < maxElem){
            maxElem = maxStack.get(maxStack.size()-1);
        }
        return popped;
    }

    @Override
    public boolean isEmpty() {
        return stack.size() == 0;
    }

    @Override
    public Integer peek() {
        return stack.get(stack.size()-1);
    }

    public Integer maxElement() {

        return maxElem;
    }
}
