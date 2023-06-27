/* Time Complexity : O(2^n * n)
 * Space Complexity: O(1)
 */
public class PowerSet {
    public static void main(String[] args) {
        String s = "abc";
        int n = s.length();
        allSubsequences(s,n);
    }
    public static void allSubsequences(String s, int n){
        //there are 2^n possible subsequences
        // 2^n - 1 ex. n=3, x= 2^3 - 1 = 7 as we starting from 0
        int x = (int)Math.pow(2,n) - 1;
       
        for(int i=0;i<=x;i++){
             String sub = "";
            for(int j=0; j<n;j++){
                // 1 << j is left shift binary operator ex. 1<<2 means 0100 (1 shifted to two bits left)
                // i & 1<<j : checks if the bit at the index is set if its not zero else it is not set
                if((i & (1<<j)) != 0){
                    sub += s.charAt(j);
                }
            }
            System.out.println(sub);
        }
    }
}
