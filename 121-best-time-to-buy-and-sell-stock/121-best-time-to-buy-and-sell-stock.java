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
        
        // int max = Integer.MIN_VALUE;
        // for(int i=0; i<nums.length; i++) {
        //     int curMax = 0;
        //     for(int j=i; j<nums.length; j++) {  // if i+1 -> i/p 1 => o/p int min -2147483648
        //         curMax+=nums[j];
        //         max = Math.max(curMax, max);
        //     }
        // }
        // return max;
        
        // int max = 0;
        // for(int i=0; i<nums.length; i++) {
        //     int curMax = 0;
        //     for(int j=i+1; j<nums.length; j++) {  // if i+1 -> i/p 1 => o/p int min -2147483648
        //         curMax=nums[j]-nums[i];
        //         max = Math.max(curMax, max);
        //     }
        // }
        // return max;
        
        // int max = 0, sum = 0;
        // for(int i=1; i<nums.length;i++) {
        //     sum += nums[i]-nums[i-1];
        //     if(max<sum) {
        //         max = sum;
        //     }
        //     if(sum<0) {
        //         sum = 0;
        //     }
        // }
        // return max;
    }
}