class Solution {
    public boolean exist(char[][] board, String word) {
    for (int row = 0; row < board.length; ++row)
      for (int col = 0; col < board[0].length; ++col)
        if (backtrack(board, row, col, word, 0))
          return true;
    return false;    
    }
    
    protected boolean backtrack(char[][] board, int row, int col, String word, int index) {
    /* Step 1). check the bottom case. */
    if (index >= word.length())
      return true;

    /* Step 2). Check the boundaries. */
    if (row < 0 || row == board.length || col < 0 || col == board[0].length
        || board[row][col] != word.charAt(index))
      return false;

    /* Step 3). explore the neighbors in DFS */
    boolean ret = false;
    // mark the path before the next exploration
    board[row][col] = '#';

    int[] rowOffsets = {0, 1, 0, -1};
    int[] colOffsets = {1, 0, -1, 0};
    for (int d = 0; d < 4; ++d) {
      ret = backtrack(board, row + rowOffsets[d], col + colOffsets[d], word, index + 1);
      if (ret)
        break;
    }

    /* Step 4). clean up and return the result. */
    board[row][col] = word.charAt(index);
    return ret;
  }
}