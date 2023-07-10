/*There is a robot on an m x n grid. The robot is initially located at the top-left corner (i.e., grid[0][0]). The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]). The robot can only move either down or right at any point in time.
Given the two integers m and n, return the number of possible unique paths that the robot can take to reach the bottom-right corner.
Input: m = 3, n = 2
Output: 3
Explanation: From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
1. Right -> Down -> Down
2. Down -> Down -> Right
3. Down -> Right -> Down
 */

import java.util.Arrays;

public class GridUniquePaths {
    static int dp[][] ;
    public static void main(String[] args) {
        int m = 3, n = 2;
        dp = new int[m][n];
        for(int row[] : dp) Arrays.fill(row,-1);
        System.out.println("Memoization:"+solveM(m-1,n-1));
        System.out.println("Tabulation:"+solveT(m-1,n-1));
        System.out.println("Space Optmization:"+solveSpaceOptimised(m,n));
    }

    /*Memoization : Dynamic Programming 
     * Time Complexity : O(M*N)
     * Space Complexity: O((N-1)+(M-1)) + O(M*N)
     * Reason: We are using a recursion stack space:O((N-1)+(M-1)), here (N-1)+(M-1) is the path length and an external DP Array of size ‘M*N’.
    */
    public static int solveM(int m, int n){
        //base case
        if(m == 0 && n == 0) return 1;
        if(m < 0 || n < 0) return 0;

        if(dp[m][n] != -1) return dp[m][n];

        int left = solveM(m,n-1);
        int up = solveM(m-1,n);

        return dp[m][n] = left + up;
    }

    /*Tabulation : Dynamic Programming 
     * Time Complexity : O(M*N)
     * Space Complexity: O(M*N)
    */
    public static int solveT(int m, int n){
        for(int i=0;i<=m;i++){
            for(int j=0;j<=n;j++){
                if(i == 0 && j == 0) dp[i][j] = 1;
                else{
                    int left = 0, up = 0;
                    if(j>0) left = dp[i][j-1];
                    if(i>0) up = dp[i-1][j];
                    dp[i][j] = left + up;
                }
            }
        }
        return dp[m][n];
    }

    /*Space Optimization 
     * Time Complexity : O(M*N)
     * Space Complexity: O(N)
    */
    public static int solveSpaceOptimised(int m, int n){
        int [] prev = new int[n];

        for(int i=0;i<m;i++){
            int temp[] = new int[n];
            for(int j=0;j<n;j++){
                if(i==0 && j==0) {
                    temp[j] = 1;
                    continue;
                }
                int up = 0, left = 0;

                if(i > 0) up = prev[j];
                if(j > 0) left = temp[j-1];

                temp[j] = up + left;
            }
            prev = temp;
        }
        return prev[n-1];
    }
}
