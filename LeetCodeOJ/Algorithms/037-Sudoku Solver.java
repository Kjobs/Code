class Solution {
    public void solveSudoku(char[][] board) {
        helper(board);
    }

    private boolean helper(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    for (char k = '1'; k <= '9'; k++) {
                        if (isValid(board, i, j, k)) {
                            board[i][j] = k;
                            if (helper(board)) return true;
                            board[i][j] = '.';
                        }
                    }
                    // 当前节点无法放置正确数字，需要进行回溯
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isValid(char[][] board, int row, int col, char ch) {
        int rowOffset = row / 3 * 3;
        int colOffset = col / 3 * 3;
        for (int i = 0; i < 9; i++) {
            // 验证行
            if (board[row][i] == ch) return false;
            // 验证列
            if (board[i][col] == ch) return false;
            // 验证当前节点所处3*3小网格，重点在于子网格横纵坐标的计算
            if (board[rowOffset + i / 3][colOffset + i % 3] == ch) return false;
        }
        return true;
    }
}

/* 回溯法求解 */
