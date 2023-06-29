/*The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.
Given an integer n, return all distinct solutions to the n-queens puzzle. You may return the answer in any order.
Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space, respectively.
Example:
Input: n = 4
Output: [[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]] */

/*Rules for n-queens:
 * Every row should have only one queen.
 * Every column should have only one queen.
 * No two queen should attack each other.
 */

/** Time Complexity: O(N! * N)
  * Space Complexity: O(N*N)
*/
import java.util.ArrayList;
import java.util.List;

class NQueens{
    public static void main(String[] args) {
        int N = 4;
        List < List < String >> queen = solveNQueens(N);
        int i = 1;
        for (List < String > it: queen) {
            System.out.println("Arrangement " + i);
            for (String s: it) {
                System.out.println(s);
            }
            System.out.println();
            i += 1;
        }
    }

    public static List<List<String>> solveNQueens(int n){
        List<List<String>> ans = new ArrayList<>();
        char [][] board = new char[n][n];
        //Initializing the board with '.'
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                board[i][j] = '.';
            }
        }
        backtrack(0,n,board,ans);
        return ans;
    }

    public static void backtrack(int column, int n, char[][] board, List<List<String>> ans){
        //base case
        if(column == n){
            ans.add(construct(board));
            return;
        }

        for(int row = 0; row < n; row++){
            if(isSafeToPlaceQ(row,column,board)){
                board[row][column] = 'Q';
                backtrack(column+1, n, board, ans);
                board[row][column] = '.';
            }
        }
    }

    /*Parsing each row of the board as a string and adding it to the list. */
    public static List<String> construct(char[][] board){
        List<String> list = new ArrayList<>();
        for(int row =0; row < board.length; row++){
            String s = new String(board[row]);
            list.add(s);
        }
        return list;
    }

    /*To verify if placing the Queeen safe at the given row and column.
    * There are total 8 direction in which a queen can be placed on a board but we dont need to care
    * about the right side directions just the left side which have already been placed i.e. also this is more logical to see where can be place the queen further if moving from left side.
    */
    public static boolean isSafeToPlaceQ(int row, int column, char[][] board){
        int dupRow = row;
        int dupCol = column;

       //checking for upper diagonal positions
       while(row >= 0 && column >= 0){
            if(board[row][column] == 'Q') return false;
            row -- ;
            column -- ;
        }

        row = dupRow;
        column = dupCol;
        //checking for lower diagonal positions
        while(row < board.length && column >= 0){
            if(board[row][column] == 'Q') return false;
            row ++;
            column --;
        }

        row = dupRow;
        column = dupCol;
        //checking for left side
        while(column >= 0){
            if(board[row][column] == 'Q') return false;
            column--;
        }

        return true;
    }
}