package your_code;

import ADTs.StackADT;

import java.util.Stack;

public class PsetProblems {

    public static int longestValidSubstring(String s) {
        int longest = 0;
        int current = 0;
        Stack stack = new Stack();
        for(int i = 0; i< s.length();i++){
            if(s.substring(i,i+1).equals("(")){
                stack.push(s.substring(i,i+1));
            }
            else{
                if(stack.isEmpty()){
                    if(current > longest){
                        longest = current;
                        current = 0;
                    }
                }
                else{
                    stack.pop();
                    current += 2;
                }
            }
        }
        if(current > longest){
            longest = current;
        }

        return longest;
    }

    public static StackADT<Integer> sortStackLimitedMemory(StackADT<Integer> s) {
        StackADT<Integer> helperStack = new MyStack();
        int tempElem = 0;
        while(!s.isEmpty()) {
            if (helperStack.isEmpty()) {
                helperStack.push(s.pop());
            }
            if ((int) helperStack.peek() >= s.peek()) {
                helperStack.push(s.pop());
            } else {
                tempElem = s.pop();
                while (!helperStack.isEmpty() && helperStack.peek() < tempElem) {
                    s.push((int) helperStack.pop());

                }
                helperStack.push(tempElem);
            }


        }
        return helperStack;
    }

}
