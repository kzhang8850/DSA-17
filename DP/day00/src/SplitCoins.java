import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class SplitCoins {
    private static int[] copyOf(int[] A) {
        int[] B = new int[A.length+1];
        System.arraycopy(A, 0, B, 0, A.length);
        return B;
    }

    public int splitCoins(int[] coins) {

        int pile1 = 0;
        int pile2 = 0;
//        ArrayList<Integer> coin = new ArrayList<Integer>();
//        for(int thing:coins){
//            coin.add(thing);
//        }
        HashMap<int[], Integer> memo = new HashMap<>();
        return coinsDP(pile1, pile2, coins, memo);
    }

    private int coinsDP(int pile1, int pile2, int[] coins, HashMap<int[], Integer> memo){
        if(coins.length == 0){
            return Math.abs(pile1 - pile2);
        }
        else if(memo.containsKey(coins)){
            return memo.get(coins);
        }
        else{
            int coin = coins[0];
            int diff = Math.min(coinsDP(pile1+coin, pile2, Arrays.copyOfRange(coins, 1, coins.length), memo), coinsDP(pile1, pile2+coin, Arrays.copyOfRange(coins, 1, coins.length), memo));
            memo.put(coins, diff);

            return diff;
        }
    }


    public static void main(String[] args){
        int[] chicken = {3,1,1,2,5,7};
        SplitCoins what = new SplitCoins();
        System.out.println(what.splitCoins(chicken));
    }
}
