class Solution {
    public int maxProfit(int[] prices) {
        // n^2, 1
        // int profit = 0;
        // for(int i=0; i<prices.length; i++) {
        //     for(int j=i+1; j<prices.length; j++) {
        //         profit = Math.max(profit, prices[j]-prices[i]);
        //     }
        // }
        // return profit;
        
        
        // n, 1
        int minPrice = Integer.MAX_VALUE, maxProfit = 0;
        for(int i=0;i<prices.length;i++) {
            int profit = prices[i]-minPrice;
            if(prices[i]<minPrice) minPrice = prices[i];
            else if(profit > maxProfit) maxProfit = profit;
        }
        return maxProfit;
    }
}