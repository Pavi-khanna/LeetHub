class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int start = Integer.MIN_VALUE, end = 0;
        int res = -1;

        // if(books.length < k) return -1;
        
        for(int i=0; i<weights.length;i++) {
            end += weights[i];
            start = Math.max(start, weights[i]);
        }
        
        while(start <= end) {
            int mid = start +(end - start)/2;
            
            if(isValid(weights, days, mid)) {
                res = mid;
                end = mid-1;
            } else {
                start = mid+1;
            }
        }
        return res;
    }
    
    boolean isValid(int[] weights, int days, int maxWeight) {
        int capacity = 1;
        int weight = 0;
        
        for(int i=0; i<weights.length; i++) {
            weight += weights[i];
            if(weight > maxWeight) {
                capacity++;
                weight = weights[i];
            }
            
            if(capacity > days) {
                return false;
            }
        }
        return true;
    }
}