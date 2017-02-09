import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Arrays;

public class Problems {

    public static Map<Integer, Integer> getCountMap(int[] arr) {
        // TODO: your code here
        MyLinearMap<Integer, Integer> CountMap = new MyLinearMap<Integer, Integer>();
        for(int item: arr){
            if(CountMap.containsKey(item)){
                CountMap.put(item, CountMap.get(item) + 1);
            }
            else{
                CountMap.put(item, 1);
            }
        }
        return CountMap;
    }

    public static List<Integer> removeKDigits(int[] num, int k) {
        // TODO: your code here
        List<Integer> result = new ArrayList<Integer>();
        int temp = k;
        for(int item: num){
            if(result.size() == 0){
                result.add(item);
            }
            else{
                while(k > 0 && result.size() > 0 && result.get(result.size()-1) > item){
                    result.remove(result.size()-1);
                    k -- ;
                }
                if(result.size() < num.length - temp){
                    result.add(item);

                }
            }
            System.out.println(result);

        }

        return result;
    }

    public static int sumLists(Node<Integer> h1, Node<Integer> h2) {
        // TODO: your code here

        Node<Integer> new_h1 = Problems.reverse(h1);
        Node<Integer> new_h2 = Problems.reverse(h2);
        int sum = 0;
        int digit = 1;
        while(new_h1 != null && new_h2 != null){

            sum = sum + (new_h1.data + new_h2.data) * digit;
            new_h1 = new_h1.next;
            new_h2 = new_h2.next;
            digit *= 10;
            System.out.println(sum);

        }
        if(new_h1 == null){
            while(new_h2 != null){
                sum = sum + new_h2.data * digit;
                new_h2 = new_h2.next;
                digit *= 10;
                System.out.println(sum);

            }
        }
        else{
            while(new_h1 != null){
                sum = sum  + new_h1.data * digit;
                new_h1 = new_h1.next;
                digit *= 10;
                System.out.println(sum);

            }
        }
        return sum;
    }
    private static Node<Integer> reverse(Node<Integer> head){
        Node reversedPart = null;
        Node current = head;
        Node next;
        while (current != null) {
            next = current.next;
            current.next = reversedPart;
            reversedPart = current;
            current = next;
        }
        head = reversedPart;

        return head;
    }

}
