public class Stocks {


    public static int maxProfit(int[] prices) {
        int max = 0;
        int bought, sold, profit;
        for (int i = 0; i < prices.length-1; i++) {
            bought = prices[i];
            for (int j = i; j < prices.length; j++) {
                sold = prices[j];
                profit = sold - bought;
                if(profit > max){
                    max = profit;
                }
            }
        }
        return max;

    }

    public int maxProfitWithK(int[] prices, int k) {
        // TODO: Optional
        return -1;
    }


    public static void main(String[] args){
        int[] prices = {5,8,1,2,6,8,7};
        Stocks chicken = new Stocks();
        System.out.println(chicken.maxProfit(prices));
    }
}
