/*Given an m x n grid of characters board and a string word, return true if word exists in the grid.
The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once. 
Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
Output: true
Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCB"
Output: false
Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SEE"
Output: true*/

public class WordSearch {
    public static void main(String[] args) {
        char[][] board = {
            {'A','B','C','E'},
            {'S','F','C','S'},
            {'A','D','E','E'}
        };
        int n = board.length;
        int m = board[0].length;

        int[][] visited = new int[n][m];

        String word = "SEE";
 
        boolean flag = false;

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(board[i][j] == word.charAt(0)){

                    visited[i][j] = 1;
                    if(exist(i,j,board,word,visited,1)){
                        flag = true;
                        break;
                    }
                    visited[i][j] = 0;
                    
                }
            }
        }
        
        System.out.println(flag);
    }
    public static boolean exist(int row, int col, char[][] board, String word,int[][] visited,int index){
        //base case
        if(index == word.length()){
            return true;
        }

        //down
        if(row+1 < board.length && visited[row+1][col] == 0 && board[row+1][col] == word.charAt(index)){
            visited[row+1][col] = 1;
            if(exist(row+1, col, board, word, visited, index+1)){
                return true;
            }
            visited[row+1][col] = 0;
        }

        //left
        if(col-1 >= 0 && visited[row][col-1] == 0 && board[row][col-1] == word.charAt(index)){
            visited[row][col-1] = 1;
            if(exist(row, col-1, board, word, visited, index+1)){
                return true;
            }
            visited[row][col-1] = 0;
        }

        //right
        if(col+1 < board[0].length && visited[row][col+1] == 0 && board[row][col+1] == word.charAt(index)){
            visited[row][col+1] = 1;
            if(exist(row, col+1, board, word, visited, index+1)){
                return true;
            }

            visited[row][col+1] = 0;
        }

        //up
        if(row-1 >= 0 && visited[row-1][col] == 0 && board[row-1][col] == word.charAt(index)){
            visited[row-1][col] = 1;
            if(exist(row-1, col, board, word, visited, index+1)){
                return true;
            }
            visited[row-1][col] = 0;
        }
        return false;

    }
}
