class Solution {
    public int pivotIndex(int[] a) {
        // n^2, 1
//         for(int i=0;i<a.length;i++) {
//             int sumLeft = 0;
//             int sumRight = 0;
            
//             for(int j=0;j<i;j++) {
//                 sumLeft+=a[j];
//             }
//             for(int j=i+1;j<a.length;j++) {
//                 sumRight += a[j];
//             }
                
//             if(sumLeft == sumRight) return i;
//         }
//         return -1;
        
        
        // n, 1
        int sum=0, leftSum=0, rightSum=0;
        for(int num:a) sum+=num;
        for(int i=0;i<a.length; i++) {
            rightSum = sum - leftSum - a[i];
            if(leftSum == rightSum) return i;
            leftSum += a[i];
        }
        return -1;
    }
}