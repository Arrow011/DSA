/*
 * In the previous solution, we were using isSafeToPlaceQ() method which had O(n) time complexity 
 * for each of the 3 directions : left , lower and upper diagonal.
 * In this approach, we optimise this method using hashing i.e. we keep a record of where we placed the Q and check again before placing another Q that if there already exists one or not.
 */
import java.util.ArrayList;
import java.util.List;

public class NQueensOptimized {
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
        int [] leftSide = new int[n];
        int [] lowerDiagonal = new int[2*n - 1];
        int [] upperDiagonal = new int[2*n - 1];

        backtrack(0,n,board,ans,leftSide,lowerDiagonal,upperDiagonal);
        return ans;
    }

    public static void backtrack(int column, int n, char[][] board, List<List<String>> ans,int[] leftSide, int[] lowerDiagonal, int[] upperDiagonal){
        //base case
        if(column == n){
            ans.add(construct(board));
            return;
        }

        for(int row = 0; row < n; row++){
            if(leftSide[row] == 0 && lowerDiagonal[row + column] == 0 && upperDiagonal[n - 1 + (column - row)] == 0){
                board[row][column] = 'Q';
                leftSide[row] = 1;
                lowerDiagonal[row + column] = 1;
                upperDiagonal[n-1+(column-row)] = 1;
                backtrack(column+1, n, board, ans, leftSide, lowerDiagonal, upperDiagonal); 
                board[row][column] = '.';
                leftSide[row] = 0;
                lowerDiagonal[row + column] = 0;
                upperDiagonal[n-1+(column-row)] = 0;
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
}
