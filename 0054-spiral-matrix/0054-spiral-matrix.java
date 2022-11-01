class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int up=0, left=0, right = matrix[0].length-1,down = matrix.length-1; 
        
        while(left<=right && up<=down) {
            // System.out.println(up+" "+down+" "+left+" "+right);
            // top row
            for(int col = left; col <= right; col++) result.add(matrix[up][col]);
        
            // right col
            for(int row = up + 1; row <= down; row++) result.add(matrix[row][right]);
            
            if(!(left<right && up<down)) { break; }
            
            // bottom row
            for (int col = right - 1; col >= left; col--) result.add(matrix[down][col]);   
            
            // left col
            for (int row = down - 1; row > up; row--) result.add(matrix[row][left]);
            
            left++; right--; up++; down--;
        }
        
        // _
        //  |  |_
        
        // int n = matrix.length, m = matrix[0].length, i=0, j=-1, dir=1;
        // while(n*m > 0) {
        //     for(int p=0; p<m; p++) {
        //         j+=dir;
        //         result.add(matrix[i][j]);
        //     }
        //     n-=1;
        //     for(int q=0; q<n; q++) {
        //         i+=dir;
        //         result.add(matrix[i][j]);
        //     }
        //     m-=1;
        //     dir *= -1;
        // }
        return result;
    }
}