/*Consider a rat placed at (0, 0) in a square matrix of order N * N. It has to reach the destination at (N - 1, N - 1). Find all possible paths that the rat can take to reach from source to destination. The directions in which the rat can move are 'U'(up), 'D'(down), 'L' (left), 'R' (right). Value 0 at a cell in the matrix represents that it is blocked and rat cannot move to it while value 1 at a cell in the matrix represents that rat can be travel through it.
Note: In a path, no cell can be visited more than one time. If the source cell is 0, the rat cannot move to any other cell.
Input:
N = 4
m[][] = {{1, 0, 0, 0},
         {1, 1, 0, 1}, 
         {1, 1, 0, 0},
         {0, 1, 1, 1}}
Output:
DDRDRR DRDDRR
Explanation:
The rat can reach the destination at 
(3, 3) from (0, 0) by two paths - DRDDRR 
and DDRDRR, when printed in sorted order 
we get DDRDRR DRDDRR. */

/**Time Complexity: O(4^(m*n)), because on every cell we need to try 4 different directions.
 * Space Complexity:  O(m*n), Maximum Depth of the recursion tree(auxiliary space). */

/*But, writing an individual code for every direction is a lengthy process therefore we truncate the 4 “if statements” into a single for loop using the following approach.
 *        Down Left Right Up
 * dRow    +1   +0   +0   -1  
 * dCol    +0   -1   +1   +0
 */
import java.util.ArrayList;
import java.util.List;

public class RatInAMaze {
    public static void main(String[] args) {
        int N = 4;
        int m[][] = {{1, 0, 0, 0},
                     {1, 1, 0, 1}, 
                     {1, 1, 0, 0},
                     {0, 1, 1, 1}};
        int vis[][] = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                vis[i][j] = 0;
            }
        }

        int[] dRow = {+1,0,0,-1};
        int[] dCol = {0,-1,+1,0};

        List<String> ans = new ArrayList<>();
        //backtrack(N,m,"",0,0, ans,vis);
        backtrackOptimized(N,m,"",0,0, ans,vis,dRow,dCol);

    if (ans.size() > 0) {
      for (int i = 0; i < ans.size(); i++)
        System.out.print(ans.get(i) + " ");
      System.out.println();
    } else {
      System.out.println(-1);
    }

    }
    public static void backtrack(int n,int[][]m, String s, int row, int col,List<String> ans, int[][] visited){
        //base case
        if(row == n-1 && col == n-1){
            ans.add(s);
            return;
        }

        //downward direction
        if(row+1 < n && visited[row+1][col] == 0 && m[row+1][col] == 1){
            visited[row+1][col] = 1;
            backtrack(n, m, s + 'D', row+1, col, ans, visited);
            visited[row+1][col] = 0;
        }

        //left
        if(col-1 >= 0 && visited[row][col-1] == 0 && m[row][col-1] == 1){
            visited[row][col-1] = 1;
            backtrack(n, m, s + 'L', row, col-1, ans, visited);
            visited[row][col-1] = 0;
        }

        //right
        if(col+1 < n && visited[row][col+1] == 0 && m[row][col+1] == 1){
            visited[row][col+1] = 1;
            backtrack(n, m, s + 'R', row, col+1, ans, visited);
            visited[row][col+1] = 0;
        }

        //upper
        if(row-1 >= 0 && visited[row-1][col] == 0 && m[row-1][col] == 1){
            visited[row-1][col] = 1;
            backtrack(n, m, s + 'U', row-1, col, ans, visited);
            visited[row-1][col] = 0;
        }
    }

    public static void backtrackOptimized(int n,int[][]m, String s, int row, int col,List<String> ans, int[][] visited, int[] dRow, int[] dCol){
        //base case
        if(row == n-1 && col == n-1){
            ans.add(s);
            return;
        }

        String direction = "DLRU"; //Lexicographically sorted order

        for(int i=0;i<4;i++){
            int nextRow = row + dRow[i];
            int nextCol = col + dCol[i];

            //checking all the conditions
            if(nextRow >=0 && nextRow < n && nextCol >=0 && nextCol < n && visited[nextRow][nextCol] == 0 && m[nextRow][nextCol] == 1){
                visited[nextRow][nextCol] = 1;
                backtrackOptimized(n, m, s + direction.charAt(i), nextRow, nextCol, ans, visited, dRow, dCol);
                visited[nextRow][nextCol] = 0;
            }
        }
    }
}

