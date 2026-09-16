class Solution {
    public boolean isValidSudoku(char[][] board) {

        boolean[][] rows = new boolean[9][9];
        boolean[][] cols = new boolean[9][9];
        boolean[][] boxes = new boolean[9][9];

        for (int i = 0; i < 9; i++) {

            for (int j = 0; j < 9; j++) {

                if (board[i][j] == '.') {
                    continue;
                }

                int num = board[i][j] - '1';

                // Find which 3x3 box this cell belongs to
                int box = (i / 3) * 3 + (j / 3);

                // Check duplicate in row
                if (rows[i][num]) {
                    return false;
                }

                // Check duplicate in column
                if (cols[j][num]) {
                    return false;
                }

                // Check duplicate in 3x3 box
                if (boxes[box][num]) {
                    return false;
                }

                // Mark the number as used
                rows[i][num] = true;
                cols[j][num] = true;
                boxes[box][num] = true;
            }
        }

        return true;
    }
}