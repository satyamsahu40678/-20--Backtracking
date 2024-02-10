// The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other. Given an integer n, return the distinct solution number of solution to the n queen puzzel.
// Input: 
// n = 4  
// Output: 
// 2  
// Explanation: 
// There are two distinct solutions to the 4-queens puzzle as shown.  
// Input:
// n = 1  
// Output:
//  1
// Assignment Q uestions


public class Question5 {

    public static boolean isSafe(char[][] board, int row, int col){
        // checking vertical row
        for(int i = 0; i < row; i++){
            if(board[i][col] == 'Q'){
                return false;
            }
        }

        // for checking left diagonal
        int maxLeft = Math.min(row, col);
        for(int i = 1; i <= maxLeft; i++){
            if(board[row - i][col - i] == 'Q'){
                return false;
            }
        }

        // for checking right diagonal
        int maxRight = Math.min(row, board.length - 1 - col);
        for(int i = 1; i <= maxRight; i++){
            if(board[row - i][col + i] == 'Q'){
                return false;
            }
        }
        return true;
    }

    public static int countNQueens(char[][] board, int row){
        if(row == board.length){
            // If reached the end of the board, a valid solution is found
            return 1;
        }

        int count = 0;
        for(int col = 0; col < board.length; col++){
            if(isSafe(board, row, col)){
                board[row][col] = 'Q';
                count += countNQueens(board, row + 1);
                board[row][col] = '.';
            }
        }
        return count;
    }

    public static int solveNQueens(int n) {
        char[][] board = new char[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                board[i][j] = '.';
            }
        }
        return countNQueens(board, 0);
    }

    public static void main(String[] args) {
        int n = 4; // Example input
        System.out.println(solveNQueens(n)); // Output: 2
    }
}
