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

        int diff = 0;
        int sum = 0;
        int index = 0;
        for (int thing: coins) {
            sum += thing;
        }

        int[][] memo = new int[sum*2+1][coins.length+1];
        for (int i = 0; i < memo.length; i++) {
            for (int j = 0; j < memo[0].length; j++) {
                memo[i][j] = sum + 1;
            }
        }
        return coinsDP(diff, index, coins, memo, sum);
    }

    private int coinsDP(int diff, int index, int[] coins, int[][] memo, int sum){
        if(index >= coins.length){
            return Math.abs(diff);
        }
        else if(memo[diff+sum][index] != (sum +1)){
            return memo[diff+sum][index];
        }
        else{
            int difference = find_min(coinsDP(diff + coins[index], index+1, coins, memo, sum), coinsDP(diff - coins[index], index+1, coins, memo, sum));
            memo[diff+sum][index] = difference;

            return Math.abs(difference);
        }
    }
    private int find_min(int a, int b){
        if(Math.abs(a)<=Math.abs(b)){
            return a;
        }
        else{
            return b;
        }
    }


    public static void main(String[] args){
        int[] chicken = {3,1,1,2,5,7};
        SplitCoins what = new SplitCoins();
        System.out.println(what.splitCoins(chicken));
    }
}
