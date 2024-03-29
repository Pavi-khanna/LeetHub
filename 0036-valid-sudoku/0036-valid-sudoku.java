class Solution {
    public boolean isValidSudoku(char[][] board) {
        int N = 9;

        // Use hash set to record the status
        // HashSet<Character>[] rows = new HashSet[N];
        // HashSet<Character>[] cols = new HashSet[N];
        // HashSet<Character>[] boxes = new HashSet[N];
        // for (int r = 0; r < N; r++) {
        //     rows[r] = new HashSet<Character>();
        //     cols[r] = new HashSet<Character>();
        //     boxes[r] = new HashSet<Character>();
        // }
        
        // int[][] rows = new int[N][N];
        // int[][] cols = new int[N][N];
        // int[][] boxes = new int[N][N];
        
        int[] rows = new int[N];
        int[] cols = new int[N];
        int[] boxes = new int[N];

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                // char val = board[r][c];
                if (board[r][c] == '.') continue;
                
                // int pos = board[r][c] - '1';
                
                int val = board[r][c] - '0';
                int pos = 1 << (val-1);

                // row
                // if (rows[r].contains(val)) return false;
                // rows[r].add(val);
                // if (rows[r][pos] == 1) return false;
                // rows[r][pos] = 1;
                if ((rows[r] & pos) > 0) return false;
                rows[r] |= pos;

                // column
                // if (cols[c].contains(val)) return false;
                // cols[c].add(val);
                // if (cols[c][pos] == 1) return false;
                // cols[c][pos] = 1;
                if ((cols[c] & pos) > 0) return false;
                cols[c] |= pos;

                // box
                int idx = (r / 3) * 3 + c / 3;
                // System.out.println(idx);
                // if (boxes[idx].contains(val)) return false;
                // boxes[idx].add(val);
                // if (boxes[idx][pos] == 1) return false;
                // boxes[idx][pos] = 1;
                if ((boxes[idx] & pos) > 0) return false;
                boxes[idx] |= pos;
            }
        }
        return true;
    }
}