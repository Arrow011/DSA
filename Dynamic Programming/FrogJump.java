/*There is a frog on the '1st' step of an 'N' stairs long staircase. The frog wants to reach the 'Nth' stair. 'HEIGHT[i]' is the height of the '(i+1)th' stair.If Frog jumps from 'ith' to 'jth' stair, the energy lost in the jump is given by absolute value of ( HEIGHT[i-1] - HEIGHT[j-1] ). If the Frog is on 'ith' staircase, he can jump either to '(i+1)th' stair or to '(i+2)th' stair. Your task is to find the minimum total energy used by the frog to reach from '1st' stair to 'Nth' stair.
 * Example : If the given ‘HEIGHT’ array is [10,20,30,10], the answer 20 as the frog can jump from 1st stair to 2nd stair (|20-10| = 10 energy lost) and then a jump from 2nd stair to last stair (|10-20| = 10 energy lost). So, the total energy lost is 20.
 */
class FrogJump{
    static int[] dp ;
    public static void main(String[] args) {
        int[] height = {10,20,30,10};
        int n = height.length;
        dp = new int[n];
        int ans = minEnergy(height,n-1);
        System.out.println("Memoization:"+ans);
        System.out.println("Tabulation:"+minEnergyTab(height,n));
        System.out.println("Space Optimized:"+minEnergyOptimized(height,n));
    }
    /*Memoization using dp[] array */
    public static int minEnergy(int[] height,int index){
        if(index == 0) return 0;
        if(dp[index] != 0) return dp[index];
        int left = minEnergy(height, index - 1) + (int)Math.abs(height[index] - height[index-1]);
        int right = Integer.MAX_VALUE;
        if(index > 1){
          right = minEnergy(height, index - 2) + (int)Math.abs(height[index] - height[index-2]);
        }

        return dp[index] = (int)Math.min(left, right);
    }

    /*Tabulation : Bottom -up approach 0 to N-1*/
    public static int minEnergyTab(int[] height, int n){
        dp[0] = 0;
        for(int i = 1; i < n; i++){
            int left = dp[i-1] + (int)Math.abs(height[i] - height[i-1]);
            int right = Integer.MAX_VALUE;
            if(i > 1){
             right = dp[i-2] + (int)Math.abs(height[i] - height[i-2]);
            }
            dp[i] = Math.min(left, right);
        }
        return dp[n-1];
    }
    /*Space optimization : Without using dp [] array */
    public static int minEnergyOptimized(int [] height, int n){
        int prev = 0, sec_prev = 0;
        for(int i = 1; i < n ; i++){
            int left = prev + (int)Math.abs(height[i] - height[i-1]);
            int right = Integer.MAX_VALUE;
            if(i > 1){
             right = sec_prev + (int)Math.abs(height[i] - height[i-2]);
            }
            sec_prev = prev;
            prev = Math.min(left, right);
        }
        return prev;
    }
}