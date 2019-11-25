class Solution {
    public boolean isValidSudoku(char[][] board) {
        if (board == null) {
            return false;
        }

        // each row
        for (int i = 0; i < 9; i++) {
            boolean[] flags = new boolean[9];
            for (int j = 0; j < 9; j++) {
                char ch = board[i][j];
                int temp = ch - '1';
                if (temp >= 0 && temp < 9 && flags[temp]) {
                    return false;
                }
                if (ch >= '1' && ch <= '9') {
                    flags[temp] = true;
                }
            }
        }

        // each column
        for (int i = 0; i < 9; i++) {
            boolean[] flags = new boolean[9];
            for (int j = 0; j < 9; j++) {
                char ch = board[j][i];
                int temp = ch - '1';
                if (temp >= 0 && temp < 9 && flags[temp]) {
                    return false;
                }
                if (ch >= '1' && ch <= '9') {
                    flags[temp] = true;
                }
            }
        }

        // each sub-boxes
        for (int block = 0; block < 9; block++) {
            boolean[] flags = new boolean[9];
            for (int i = block / 3 * 3; i < block / 3 * 3 + 3; i++) {
                for (int j = block % 3 * 3; j < block % 3 * 3 + 3; j++) {
                    char ch = board[i][j];
                    int temp = ch - '1';
                    if (temp >= 0 && temp < 9 && flags[temp]) {
                        return false;
                    }
                    if (ch >= '1' && ch <= '9') {
                        flags[temp] = true;
                    }
                }
            }
        }
        return true;
    }
}
