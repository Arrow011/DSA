import java.util.Arrays;

/**Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right, which minimizes the sum of all numbers along its path.
Note: You can only move either down or right at any point in time.
Input: grid = [[1,3,1],[1,5,1],[4,2,1]]
Output: 7
Explanation: Because the path 1 → 3 → 1 → 1 → 1 minimizes the sum. */
public class MinimumPathSumInGrid {
    public static void main(String[] args) {
        int [][] grid = {{1,3,1},{1,5,1},{4,2,1}};
        int m = grid.length, n = grid[0].length;

        int[][] dp = new int[m][n];
        for(int row[] : dp) Arrays.fill(row,-1);

        System.out.println("Recursion: "+ solveR(0,0,m,n,grid));
        System.out.println("Memoization: "+solveM(0,0,m,n,grid,dp));
        System.out.println("Tabluation: "+solveT(m,n,grid));
        System.out.println("Space Optimization: "+solveO(m,n,grid));
    }

    /*Recursive implementation : 
     * Time Complexity: O(2 ^ ((M-1) +(N-1)) ~ O(2^ (M+N))
     * Space Complexity: O((M-1) + (N-1)) ~ O(M + N) -> depth of recursion
     */
    public static int solveR(int row, int col, int m, int n, int[][] grid){
        //base case
        if(row == m-1 && col == n-1) return grid[m-1][n-1];

        /*When i<0 or j<0, it means that we have crossed the boundary of the matrix and we don’t want to 
        find a path from here, so we return a very large number( say, 1e9) so that this path is rejected 
        by the last calling function (as we will be returning the minimum path). */
        if(row > m-1 || col > n-1) return (int)Math.pow(10,9);

        //for right direction
        int right = grid[row][col] + solveR(row,col+1,m,n,grid);

        //for down direction
        int down = grid[row][col] + solveR(row+1,col,m,n,grid);

        return Math.min(right,down);
    }

    /*Memoization : Dynamic Programming 
     * Time Complexity: O(M*N) -> At max it will visit each element in the M*N array
     * Space Complexity: O( (M-1)+(N-1) ) + O(M*N) -> We are using a recursion stack space:O((M-1)+(N-1)), here (M-1)+(N-1) is the path length and an external DP Array of size ‘N*M’.
    */
    public static int solveM(int row, int col, int m, int n, int[][] grid, int[][] dp){
        if(row == m-1 && col == n-1) return grid[row][col];
        if(row > m-1 || col > n-1) return (int) Math.pow(10,9);

        if(dp[row][col] != -1) return dp[row][col];

        int right = grid[row][col] + solveM(row,col+1,m,n,grid,dp);
        int down  = grid[row][col] + solveM(row+1,col,m,n,grid,dp);

        return dp[row][col] = Math.min(right,down);
    }

    /*Tabulation: Dynamic Programming
     * We try to optimize and remove the extra recursive stack space
     * Time Complexity : O(M*N)
     * Space Complexity: O(M*N)
     */
    public static int solveT(int m, int n, int[][] grid){
        int[][] prev = new int[m][n];
        int max = (int) Math.pow(10,9);

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(i==0 && j==0) prev[i][j] = grid[i][j];
                else{
                    int right = grid[i][j];
                    //requiring current row's previous column
                    if(j>0) right += prev[i][j-1];
                    else right += max;

                    int down = grid[i][j];
                    //requiring previous row's current column
                    if(i>0) down += prev[i-1][j];
                    else down += max;

                    prev[i][j] = Math.min(right,down);
                }
            }
        }
        return prev[m-1][n-1];
    }

    /*Space Optimization : Without using M*N array 
     * If we closely look at the relation, dp[i][j] = matrix[i][j] + min(dp[i-1][j] + dp[i][j-1]))
     * We see that we only need the previous row and column, in order to calculate dp[i][j]. Therefore we can space optimize it.
     * Time Complexity : O(M*N)
     * Space Complexity : O(N) -> We are using an external array of size ‘N’ to store only one row.
    */
    public static int solveO(int m, int n, int[][] grid){
        /*Array to keep record of previous row */
        int prev[] = new int[n];
        int max = (int) Math.pow(10,9);

        for(int i = 0; i < m; i++){
            /*Temporary array to keep record of the current row */
            int temp[] = new int[n];
            for(int j = 0; j < n; j++){
                if(i == 0 && j == 0) temp[j] = grid[i][j];
                else{
                    int right = grid[i][j];
                    if(j>0) right += temp[j-1];
                    else right += max;

                    int down = grid[i][j];
                    if(i>0) down += prev[j];
                    else down += max;

                    temp[j] = Math.min(right,down);
                }
            }
            prev = temp;
        }
        return prev[n-1];
    }
}
