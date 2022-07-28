class Solution {
    public int shipWithinDays(int[] books, int k) {
        int start = Integer.MIN_VALUE, end = 0;
        int res = -1;

        // if(books.length < k) return -1;
        
        for(int i=0; i<books.length;i++) {
            end += books[i];
            start = Math.max(start, books[i]);
        }
        
        while(start <= end) {
            int mid = start +(end - start)/2;
            
            if(isValid(books, k, mid)) {
                res = mid;
                end = mid-1;
            } else {
                start = mid+1;
            }
        }
        return res;
    }
    
    boolean isValid(int[] books, int k, int maxPages) {
        int student = 1;
        int sum = 0;
        
        for(int i=0; i<books.length; i++) {
            sum += books[i];
            if(sum > maxPages) {
                student++;
                sum = books[i];
            }
            
            if(student > k) {
                return false;
            }
        }
        return true;
    }
}