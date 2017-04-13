import java.util.Arrays;

public class BillsNeeded {

    public int billsNeeded(int N, int[] billDenominations) {

        int[] memo = new int[N + 1];
        for (int i = 0; i < memo.length; i++) {
            memo[i] = -1;
        }

        return billDP(N, billDenominations, memo);
    }

    private int billDP(int N, int[] bills, int[] memo){
        if(N == 0){
            return 0;
        }
        else if(N < 0){
            return 1000;
        }
        else if(memo[N] != -1){
            return memo[N];
        }
        else{
            int[] numbills = new int[bills.length];
            for (int i = 0; i < bills.length; i++) {
                numbills[i] = billDP(N-bills[i], bills, memo) + 1;
            }
            Arrays.sort(numbills);
            memo[N] = numbills[0];
            return numbills[0];
        }

    }


    public static void main(String[] args){
        int number = 49;
        int[] bills = {1,15,25};
        BillsNeeded chicken = new BillsNeeded();
        System.out.println(chicken.billsNeeded(number, bills));

        number = 17;
        int[] bill2 = {2,4,5,7,9};
        System.out.println(chicken.billsNeeded(number, bill2));
    }



}
