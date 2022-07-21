class Solution {
    public int sumOddLengthSubarrays(int[] arr) {
        // n^2, 1
//         int i = 0, j = 0;
//         int sumTotal = 0, n = arr.length;
                
//         for(int window=1; window<=arr.length; window+=2) {
//             int sum = 0;
//             j=0; i=0;
//             while(j < n) {
//                 sum += arr[j];
            
//                 if(j-i+1 == window) {
//                     sumTotal+=sum;
//                     sum -= arr[i];
//                     i++;
//                 }
//                 j++;
//             }
//         }
//         return sumTotal;
        
        
 //        1  4  2  5  3
 // times :3  4  5  4  3
 // total :3 16 10 20  9 = 58
        // odd - k+1/2 & even - k/2 where k = no of subarrays
        // n, 1
        int sum=0, n=arr.length;
        for(int i=0; i<n; i++) {
            sum += (((i+1)*(n-i)+1)/2)*arr[i];
        }
        return sum;
    }
}