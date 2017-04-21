public class Stocks {


    public static int maxProfit(int[] prices) {
        int maxProfit = 0;
        int minPrice = 1000000000;
        for (int i = 0; i < prices.length; i++) {
            if(prices[i]<minPrice){
                minPrice = prices[i];
            }
            int profit = prices[i] - minPrice;
            if(profit>maxProfit){
                maxProfit = profit;
            }
        }
        return maxProfit;

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
