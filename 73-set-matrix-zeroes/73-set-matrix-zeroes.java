class Solution {
    public void setZeroes(int[][] matrix) {
        // 2*m*n, m+n // dont modify  // can it have neg elements
//         int rows = matrix.length, cols = matrix[0].length;
//         int rowDummy[] = new int[rows], colDummy[] = new int[cols];
//         Arrays.fill(rowDummy, -1);
//         Arrays.fill(colDummy, -1);
        
//         for(int i=0;i<rows;i++) {
//             for(int j=0;j<cols;j++) {
//                 if(matrix[i][j]==0) {
//                     rowDummy[i]=0;
//                     colDummy[j]=0;
//                 }
//             }
//         }
        
//         for(int i=0;i<rows;i++) {
//             for(int j=0;j<cols;j++) {
//                 if(rowDummy[i]==0 || colDummy[j]==0) {
//                     matrix[i][j]=0;
//                 }
//             }
//         }
        
        
        // 2*m*n, 1
        int col0 = 1, rows = matrix.length, cols = matrix[0].length;
        
        // 1st traversal
        for(int i=0;i<rows;i++) {
            if(matrix[i][0] == 0) col0=0;
            for(int j=1;j<cols;j++) {
                if(matrix[i][j] == 0) {
                    matrix[i][0] = matrix[0][j] = 0;
                }
            }
        }
        
        // 2nd traversal
        for(int i=rows-1;i>=0;i--) {
            for(int j=cols-1;j>=1;j--) {
                if(matrix[i][0]==0 || matrix[0][j]==0) {
                    matrix[i][j]=0;
                }
            }
            if(col0==0) matrix[i][0]=0;
        }
    }
}