import java.util.ArrayList;
import java.util.List;

public class NQueens {

    /**
     * Creates a deep copy of the input array and returns it
     */
    private static char[][] copyOf(char[][] A) {
        char[][] B = new char[A.length][A[0].length];
        for (int i = 0; i < A.length; i++)
            System.arraycopy(A[i], 0, B[i], 0, A[0].length);
        return B;
    }
    private static void populate(char[][] currentsol, int n){
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                currentsol[i][j] = '.';
            }
        }
    }

    public static List<char[][]> nQueensSolutions(int n) {
        List<char[][]> solution = new ArrayList<>();
        char[][] currentsol = new char[n][n];
        int numQueens = n;
        int row = 0;
        int col = 0;
        populate(currentsol, n);
        return Queens(solution, currentsol, numQueens, row, col, n);
    }

    public static List<char[][]> Queens(List<char[][]> solution, char[][]currentsol, int numQueens, int row, int col, int n){
        if(numQueens == 0){
            solution.add(copyOf(currentsol));
            return solution;
        }
        else{
            for (int i = 0; i < n; i++) {
                    if(validSpot(currentsol,i, col, n)){
                        currentsol[i][col] = 'Q';
                        Queens(solution, currentsol, numQueens - 1, i, col+1, n);
                        currentsol[i][col] = '.';
                    }

            }

            return solution;

        }



    }

    public static boolean validSpot(char[][] board, int row, int col, int n){
        boolean valid = true;
        int temprow = row;
        int tempcol = col;
        while(temprow < n){
            if(board[temprow][tempcol] == 'Q'){
                valid = false;
                return valid;
            }
            temprow ++;
        }
        temprow = row;
        tempcol = col;
        while(temprow > -1){
            if(board[temprow][tempcol] == 'Q'){
                valid = false;
                return valid;
            }
            temprow --;
        }
        temprow = row;
        tempcol = col;
        while(tempcol < n){
            if(board[temprow][tempcol] == 'Q'){
                valid = false;
                return valid;
            }
            tempcol ++;
        }
        temprow = row;
        tempcol = col;
        while(tempcol > -1){
            if(board[temprow][tempcol] == 'Q'){
                valid = false;
                return valid;
            }
            tempcol --;
        }
        temprow = row;
        tempcol = col;
        while((temprow < n) && (tempcol < n)){
            if(board[temprow][tempcol] == 'Q'){
                valid = false;
                return valid;
            }
            temprow++;
            tempcol++;

        }
        temprow = row;
        tempcol = col;
        while((temprow <n) && (tempcol > -1)){
            if(board[temprow][tempcol] == 'Q'){
                valid = false;
                return valid;
            }
            temprow ++;
            tempcol --;

        }
        temprow = row;
        tempcol = col;
        while((temprow > -1) && (tempcol < n)){
            if(board[temprow][tempcol] == 'Q'){
                valid = false;
                return valid;
            }
            temprow--;
            tempcol++;
        }
        temprow = row;
        tempcol = col;
        while((temprow > -1) && (tempcol > -1)){
            if(board[temprow][tempcol] == 'Q'){
                valid = false;
                return valid;
            }

            temprow --;
            tempcol --;
        }




        return valid;
    }



}
