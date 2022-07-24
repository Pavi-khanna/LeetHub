class Solution {
    public int maxProfit(int[] prices) {
        // n^n, 1
        return dp(prices,1,0);
        
        
        // n, 1
//         int total = 0, valley = Integer.MAX_VALUE, peak = valley;
//         for(int i=0;i<prices.length;i++) {
//             if(prices[i]<peak) {
//                 total+=peak-valley;
                
//                 valley = prices[i];
//                 peak = valley;
//             } else {
//                 peak = prices[i];
//             }
//         }
//         total+=peak-valley;
//         return total;
        
        
        // n, 1
        // int total = 0;
        // for(int i=1;i<prices.length;i++) {
        //     if(prices[i]>prices[i-1]) {
        //         total+=prices[i] - prices[i-1];
        //     }
        // }
        // return total;
    }
    
    private  int dp(int[] prices,int index,int profit){
    if(index > prices.length-1)
        return  profit;
    if(prices[index]>prices[index-1]){
        profit += prices[index]-prices[index-1];
    }
    return dp(prices,index+1,profit);
    }
}