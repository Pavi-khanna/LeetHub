class Solution {
    public int maxProfit(int[] nums) {
        // n^2, 1
        // int profit = 0;
        // for(int i=0; i<prices.length; i++) {
        //     for(int j=i+1; j<prices.length; j++) {
        //         profit = Math.max(profit, prices[j]-prices[i]);
        //     }
        // }
        // return profit;
        
        
        // n, 1
        // int minPrice = Integer.MAX_VALUE, maxProfit = 0;
        // for(int i=0;i<prices.length;i++) {
        //     int profit = prices[i]-minPrice;
        //     if(prices[i]<minPrice) minPrice = prices[i];
        //     else if(profit > maxProfit) maxProfit = profit;
        // }
        // return maxProfit;
        
        
        // kadane
        
        // int max = 0;                                 // change here
        // for(int i=0; i<nums.length; i++) {
        //     int curMax = 0;
        //     for(int j=i+1; j<nums.length; j++) {     // change here
        //         curMax=nums[j]-nums[i];              // change here
        //         max = Math.max(curMax, max);
        //     }
        // }
        // return max;
        
        
        int max = 0, sum = 0;                            // change here
        for(int i=1; i<nums.length;i++) {                // change here
            sum += nums[i]-nums[i-1];                    // change here
            if(sum<0) sum = 0;
            if(max<sum) {
                max = sum;
            }
            // System.out.println(max +" "+sum);
        }
        return max;
    }
}