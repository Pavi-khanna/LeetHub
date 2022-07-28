class Solution {
    public boolean searchMatrix(int[][] matrix, int t) {
        // mn, 1
        // for(int i=0; i<matrix.length; i++) {
        //     for(int j=0; j<matrix[0].length; j++) {
        //         if(t == matrix[i][j]) return true;
        //     }
        // }
        // return false;
        
        
        // n, 1
//         int n = matrix.length, m = matrix[0].length; 
//         int i=0, j=m-1;
//         while(i<n && j>=0) {
//             if(matrix[i][j]==t) return true;
            
//             if(matrix[i][j]>t) j--;
//             else i++;
//         }
//         return false;
        
        
        // log(mn), 1
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
        
        
        int mid, low =0, high=matrix.length-1;
        while(low<=high) {
            mid = (low +(high-low)/2);
            if(t>=matrix[mid][0] && t<=matrix[mid][matrix[0].length-1]) return search(t, matrix[mid], 0, matrix[0].length-1);
            else if(matrix[mid][0]<t) low = mid+1;
            else high = mid-1;
        }
        return false;
    }
    
    public boolean search(int target, int[] arr, int low, int high) {
        int mid;
        while(low<=high) {
            mid = (low +(high-low)/2);
            if(arr[mid] == target) return true;
            else if(arr[mid]<target) low = mid+1;
            else high = mid-1;
        }
        return false;
    }
}