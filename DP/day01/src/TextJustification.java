import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class TextJustification {

    public static List<Integer> justifyText(String[] w, int m) {
         HashMap<Integer, Integer> sol = new HashMap<>();

         double[] memo = new double [w.length+1];
        return justify(w, m, sol, memo);
    }

    private static List<Integer> justify(String[] w, int m, HashMap<Integer, Integer>  sol, double[] memo){

        memo[w.length] = 0;

        for (int i = w.length-1; i >=0 ; i--) {
            double min = Double.POSITIVE_INFINITY;
            int argmin = i+1;

            for (int j = i+1; j <w.length+1; j++) {
                double cos = memo[j] + find_cost(i, j, m, w);
                if (cos < min) {
                    min = cos;
                    argmin = j;
                }

            }
            memo[i] = min;
            sol.put(i, argmin);
        }

//        for (Integer name: sol.keySet()){
//
//            String key =name.toString();
//            String value = sol.get(name).toString();
//            System.out.println(key + " " + value);
//
//
//        }

        List<Integer> solution = new ArrayList<>();
        int index = 0;
        while(sol.containsKey(index)){
            solution.add(index);
            index = sol.get(index);
        }

        return solution;
    }


    private static double find_cost(int start, int end, int m, String[] w){
        int total_length = 0;
        double cost;
        total_length += end - start-1;
        for (int i = start; i < end; i++) {
            total_length += w[i].length();
        }
        if(total_length > m){
            cost = Double.POSITIVE_INFINITY;
        }
        else{
            cost = Math.pow(m-total_length,3);
        }

        return cost;
    }

    public static void main(String[] args){
        double cost = Double.POSITIVE_INFINITY;
        if(cost > 5){
            System.out.println("true");
        }
        System.out.println(Math.min(5, Double.POSITIVE_INFINITY+5));
    }


}