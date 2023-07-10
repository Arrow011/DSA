/*Ninja is planing this ‘N’ days-long training schedule. Each day, he can perform any one of these three activities. (Running, Fighting Practice or Learning New Moves). Each activity has some merit points on each day. As Ninja has to improve all his skills, he can’t do the same activity in two consecutive days. Can you help Ninja find out the maximum merit points Ninja can earn?
You are given a 2D array of size N*3 ‘POINTS’ with the points corresponding to each day and activity. Your task is to calculate the maximum number of merit points that Ninja can earn.
If the given ‘POINTS’ array is [[1,2,5], [3 ,1 ,1] ,[3,3,3] ],the answer will be 11 as 5 + 3 + 3.
Input : 
10 40 70
20 50 80
30 60 90 
Output : 210*/

import java.util.Arrays;

class NinjaTraining{
    public static void main(String[] args) {
        int ar[][] = {{10,40,70},{20,50,80},{30,60,90}};
        int dp[][] = new int[ar.length][4];
        for(int row[] : dp) Arrays.fill(row,-1);
        System.out.println("Recursion Solution :" +maximumMerit(ar,0,3));
        System.out.println("Memoization Solution:"+maximumMeritMemoization(ar, 0, 3,dp));
        System.out.println("Tabulation:"+maximumMeritTabulation(ar,ar.length,dp));
        System.out.println("Space Optimized:"+maximumMeritSpaceOptimized(ar,ar.length));
    }
    public static int maximumMerit(int[][] ar, int index, int lastActivity){
        //base case
        if(index == ar.length - 1){
            int max = 0;
            for(int i=0; i<3;i++){
                if(i != lastActivity){
                    max = Math.max(ar[index][i], max);
                }
            }
            return max;
        }
        int maximum = 0;
        for(int i = 0; i < 3; i++){
            if(i != lastActivity){
                int merits = ar[index][i] + maximumMerit(ar, index + 1, i); 
                maximum = Math.max(maximum, merits);
            }
        }

        return maximum;
    }

    /*Optimizing for overlapping sub-problems in recursion with Memoization of DP.*/
    public static int maximumMeritMemoization(int[][] ar, int index, int lastActivity, int[][] dp){

        if(dp[index][lastActivity] != -1) return dp[index][lastActivity];

        //base case
        if(index == ar.length - 1){
            int max = 0;
            for(int i=0; i<3;i++){
                if(i != lastActivity){
                    max = Math.max(ar[index][i], max);
                }
            }
            return dp[index][lastActivity] = max;
        }

        int maximum = 0;
        for(int i=0;i<3;i++){
            if(i != lastActivity){
                int merits = ar[index][i] + maximumMeritMemoization(ar, index + 1, i, dp);
                maximum = Math.max(maximum, merits);
            }
        }

        return dp[index][lastActivity] = maximum;
    }

    /*Tabulation  -- bottom up */
    public static int maximumMeritTabulation(int[][] ar, int n, int[][]dp){
        dp[0][0] = Math.max(ar[0][1], ar[0][2]);
        dp[0][1] = Math.max(ar[0][0], ar[0][2]);
        dp[0][2] = Math.max(ar[0][0], ar[0][1]);
        dp[0][3] = Math.max(ar[0][0], Math.max(ar[0][1], ar[0][2]));


        for(int day = 1; day < ar.length; day++){
            for(int last = 0; last < 4; last++){
                dp[day][last] = 0;
                for(int task = 0; task <= 2; task++){
                    dp[day][last] = Math.max(dp[day][last], ar[day][task] + dp[day - 1][task]);
                }
            }
        }

        return dp[n-1][3];
    }

    /*Space Optimization, we can see that to get the dp array values of ith row we need the i-1 row values (reference tabulation method)
     * hence, we dont need to have 2D dp array and can just use a 1D array of length 4 which will act as previous and a temp array.
     */
    public static int maximumMeritSpaceOptimized(int[][] ar, int n){
        int [] prev = new int [4];

        prev[0] = Math.max(ar[0][1], ar[0][2]);
        prev[1] = Math.max(ar[0][0], ar[0][2]);
        prev[2] = Math.max(ar[0][0], ar[0][1]);
        prev[3] = Math.max(ar[0][0], Math.max(ar[0][1], ar[0][2]));

        for(int day = 1; day < n; day++){
            int temp[] = new int[4];
            for(int last = 0; last < 4; last++){
                temp[last] = 0;
                for(int task = 0; task <=2 ; task++){
                    if(task != last)
                        temp[last] = Math.max(temp[last], ar[day][task] + prev[task]);
                }
            }
            prev = temp;
        }
        return prev[3];
    }
}