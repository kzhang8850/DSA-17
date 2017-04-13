import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Arrays;

public class Permutations {

    public static List<List<Integer>> permutations(List<Integer> A) {
        List<List<Integer>> chicken = new LinkedList<>();
        List<Integer> copyOfA = new ArrayList<>();
        copyOfA.addAll(A);
        int num = 0;

        return perms(copyOfA, num, chicken);
    }

    public static List<List<Integer>> perms(List<Integer> arr, int index, List<List<Integer>> masterlist){
        if(index >= arr.size() - 1){ //If we are at the last element - nothing left to permute
            List<Integer> temp = new ArrayList<>();
            temp.addAll(arr);
            masterlist.add(temp);
            return masterlist;
        }

        for(int i = index; i < arr.size(); i++){ //For each index in the sub array arr[index...end]

            //Swap the elements at indices index and i
            int t = arr.get(index);
            arr.set(index, arr.get(i));
            arr.set(i, t);

            //Recurse on the sub array arr[index+1...end]
            masterlist = perms(arr, index+1, masterlist);

            //Swap the elements back
            t = arr.get(index);
            arr.set(index, arr.get(i));
            arr.set(i, t);
        }
        return masterlist;
    }

    public static void swap(List<Integer> arr, int a, int b){
        int temp = arr.get(a);
        arr.set(a, arr.get(b));
        arr.set(b, temp);
    }





}
