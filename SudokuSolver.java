import java.util.Arrays;

public class SudokuSolver {
    public static void main(String[] args) {
        int[][] board = { {0,5,0,9,0,0,0,0,0},  
                          {0,0,9,0,2,0,7,0,0},
                          {0,1,0,0,8,5,0,3,0},
                          {0,0,0,0,0,0,3,0,8},
                          {7,9,0,0,0,0,0,5,6},
                          {2,0,6,0,0,0,0,0,0},
                          {0,7,0,5,1,0,0,6,0},
                          {0,0,4,0,3,0,9,0,0},
                          {0,0,0,0,0,4,0,7,0} };
                          boolean x = SolveSudoku(board);
                          for (int[] is : board) {
                                System.out.println(Arrays.toString(is));
                          }
    }
    public static boolean ISSafe(int[][] board , int r , int c , int num ) {
        for (int i = 0; i < board.length; i++) {
            if (board[i][c] == num ) {
                return false;
            }
            if (board[r][i] == num) {
                return false;
            }
           
        }
        int sqrt = (int)Math.sqrt(board.length);
        int RStart = r - r%sqrt;
        int CStart = c - c%sqrt;
        for (int i = RStart; i < RStart + sqrt; i++) {
            for (int j = CStart; j < CStart + sqrt; j++) {
                if (board[i][j] == num) {
                    return false;
                }
            }
        }
    return true;
    }
    public static boolean SolveSudoku(int[][]board) {
        int r = -1;
        int c = -1;
        int n = board.length;
        boolean EmptyLeft = true;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n;j++) {
               if ( board[i][j] == 0) {
                r=i;
                c=j;
                EmptyLeft = false;
                break;
               }
               
            }
            if (!EmptyLeft) {
                break;
            }
        }
        if (EmptyLeft) {
            return true;
        }
        for (int number = 1; number <= board.length; number++) {
            if (ISSafe(board, r, c, number)) {
                board[r][c] = number;
                if (SolveSudoku(board)) { 
                    return true;
                }else {
                    board[r][c] = 0;
                }
            }
        }
    return false;
    }
}
