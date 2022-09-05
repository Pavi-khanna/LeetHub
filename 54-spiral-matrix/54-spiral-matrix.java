class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int up=0, left=0, right = matrix[0].length-1,down = matrix.length-1; 
        
        while(left<=right && up<=down) {
            // top row
            for(int col = left; col <= right; col++) {
                result.add(matrix[up][col]);
            }
            
            // right col
            for(int row = up + 1; row <= down; row++) {
                result.add(matrix[row][right]);
            }
            
            //if(!(left<right && up<down)) {break;}
            
            // bottom row
            if(up<down) {
            for (int col = right - 1; col >= left; col--) {
                result.add(matrix[down][col]);
                }    
            }
            
            // left col
            if(left<right) {
            for (int row = down - 1; row > up; row--) {
                result.add(matrix[row][left]);
                }
            }
            
            left++;
            right--;
            up++;
            down--;
        }
        return result;
    }
}