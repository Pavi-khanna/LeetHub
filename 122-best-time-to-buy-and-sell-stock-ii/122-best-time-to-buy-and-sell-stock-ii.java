class Solution {
    public int maxProfit(int[] prices) {
        int total = 0, valley = Integer.MAX_VALUE, peak = valley;
        
        for(int i=0;i<prices.length;i++) {
            if(prices[i]<peak) {
                total+=peak-valley;
                
                valley = prices[i];
                peak = valley;
            } else {
                peak = prices[i];
            }
        }
        total+=peak-valley;
        return total;
        
        
//         int total = 0;
//         for(int i=1;i<prices.length;i++) {
//             if(prices[i]>prices[i-1]) {
//                 total+=prices[i] - prices[i-1];
//             }
//         }
//         return total;
    }
}