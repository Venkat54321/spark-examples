package problems;

public class AvailableCapturesForRook {

    public static void main(String[] args) {
        char board[][] = {{'.','.','.','.','.','.','.','.'},
                          {'.','.','.','p','.','.','.','.'},
                          {'.','.','.','R','.','.','.','p'},
                          {'.','.','.','.','.','.','.','.'},
                          {'.','.','.','.','.','.','.','.'},
                          {'.','.','.','p','.','.','.','.'},
                          {'.','.','.','.','.','.','.','.'},
                          {'.','.','.','.','.','.','.','.'}};

        int count = getRookCount(board);
        System.out.println(count);
    }

    private static int getRookCount(char[][] board) {

        int row = board.length;
        int column = board[0].length;
        int iPosition = 0;
        int jPosition = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (board[i][j] == 'R') {
                    // System.out.println(i + ' ' + j);
                    iPosition = i;
                    jPosition = j;
                    break;
                }
            }
        }
        System.out.println(iPosition);
        System.out.println(jPosition);
        //Row
        int count = 0;
        boolean isFound = isRowLeftFound(board, iPosition, jPosition - 1);
        boolean isFound1 = isRowRightFound(board, iPosition, jPosition + 1);
        System.out.println(isFound1);
        //column
        boolean isFound2 = isColumnTopFound(board, iPosition - 1, jPosition);
        boolean isFound3 = isColumnDownFound(board, iPosition + 1, jPosition);
        if(isFound){
           count++;
        }
        if(isFound1){
            count++;
        }
        if(isFound2){
            count++;
        }
        if(isFound3){
            count++;
        }


        return count;
    }

    private static boolean isColumnDownFound(char[][] board, int i, int jPosition) {
        while (i <= 7) {
            if (board[i][jPosition] == 'B') {
                break;
            }
            if (board[i][jPosition] == 'p') {
                return true;
            }
            i++;
        }
        return false;
    }

    private static boolean isColumnTopFound(char[][] board, int iPosition, int jPosition) {
        while (iPosition >= 0) {
            if (board[iPosition][jPosition] == 'B') {
                break;
            }
            if (board[iPosition][jPosition] == 'p') {
                return true;
            }
            iPosition--;
        }
        return false;
    }

    private static boolean isRowLeftFound(char[][] board, int iPosition, int LeftJPosition) {
        while (LeftJPosition >= 0) {
            if (board[iPosition][LeftJPosition] == 'B') {
                break;
            }
            if (board[iPosition][LeftJPosition] == 'p') {
                return true;
            }
            LeftJPosition--;
        }
        return false;
    }

    private static boolean isRowRightFound(char[][] board, int iPosition, int rightJPosition) {
        while (rightJPosition <= 7) {
            if (board[iPosition][rightJPosition] == 'B') {
                break;
            }
            if (board[iPosition][rightJPosition] == 'p') {
                return true;
            }
            rightJPosition++;
        }
        return false;
    }
}

