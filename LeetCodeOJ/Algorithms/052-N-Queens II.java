class Solution {
    private int count = 0;

    public int totalNQueens(int n) {
        int[] position = new int[n];
        helper(position, 0);
        return count;
    }

    private void helper(int[] position, int row) {
        if (row == position.length) {
            count++;
            return;
        }
        for (int col = 0; col < position.length; col++) {
            position[row] = col;
            if (isValid(position, row)) {
                helper(position, row + 1);
            }
        }
    }

    private boolean isValid(int[] position, int row) {
        for (int i = 0; i < row; i++) {
            if (position[i] == position[row] || Math.abs(position[row] - position[i]) == Math.abs(row - i)) {
                return false;
            }
        }
        return true;
    }
}
