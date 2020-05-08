class Solution {
    public void setZeroes(int[][] matrix) {
        int rowLen = matrix.length;
        int colLen = matrix[0].length;
        boolean rFlag = false;
        boolean cFlag = false;
        for (int i = 0; i < rowLen; i++) {
            for (int j = 0; j < colLen; j++) {
                if(matrix[i][j] == 0) {
                    if (i == 0) rFlag = true;
                    if (j == 0) cFlag = true;
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        for (int i = 1; i < rowLen; i++) {
            if(matrix[i][0] == 0) {
                for(int j = 1; j < colLen; j++) {
                    matrix[i][j] = 0;
                }
            }
        }

        for (int j = 1; j < colLen; j++) {
            if (matrix[0][j] == 0) {
                for (int i = 1; i < rowLen; i++) {
                    matrix[i][j] = 0;
                }
            }
        }

        if (rFlag) {
            for (int i = 0; i < colLen; i++) {
                matrix[0][i] = 0;
            }
        }
        if (cFlag) {
            for (int i = 0; i < rowLen; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}
