class Solution {
    public int sumOddLengthSubarrays(int[] arr) {
        int i = 0, j = 0;
        int sumTotal = 0, n = arr.length;
                
        for(int window=1; window<=arr.length; window+=2) {
            int sum = 0;
            j=0; i=0;
            while(j < n) {
                sum += arr[j];
            
                if(j-i+1 == window) {
                    sumTotal+=sum;
                    sum -= arr[i];
                    i++;
                }
                j++;
            }
        }
        return sumTotal;
    }
}