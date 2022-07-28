class Solution {
    public boolean searchMatrix(int[][] matrix, int t) {
        for(int i=0; i<matrix.length; i++) {
            for(int j=0; j<matrix[0].length; j++) {
                if(t == matrix[i][j]) return true;
            }
        }
        return false;
        
        
//         int n = matrix.length, m = matrix[0].length; 
//         int i=0, j=m-1;
//         while(i<n && j>=0) {
//             if(matrix[i][j]==t) return true;
            
//             if(matrix[i][j]>t) j--;
//             else i++;
//         }
//         return false;
        
        // int n = matrix.length; 
        // int m = matrix[0].length; 
        // int lo = 0, hi = n*m-1;
        // while(lo <= hi) {
        //     int mid = (lo+(hi-lo)/2);
        //     if(matrix[mid/m][mid%m] == t){
        //         return true;
        //     }
        //     if(matrix[mid/m][mid%m] < t) {
        //         lo = mid+1;
        //     }
        //     else{
        //         hi = mid-1;
        //     }
        // }
        // return false;
    }
}