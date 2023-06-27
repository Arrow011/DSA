import java.util.ArrayList;

import java.util.List;

/**Input: candidates = [2,3,6,7], target = 7
Output: [[2,2,3],[7]]
Explanation:
2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.
7 is a candidate, and 7 = 7.
These are the only two combinations. */

/*Time Complexity : O(2^t * k) 
 * At every index we have two choices either to pick or not pick that element and as same index can be picked multiple times we cannot say it to be 2^n 
 * k is the number of combinations that is also variable
 * Space Complexity : Number of combinations
*/
class CombinationSum{
    public static void main(String[] args) {
        int[] candidates = {2,3,6,7};
        int target = 7;
        List<List<Integer>> answer = combinationSum(candidates,target);
        System.out.print(answer);
    }
     public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        findCombination(0, candidates, target, ans, new ArrayList<>());
        return ans;
    }
    public static void findCombination(int index, int[] ar, int target, List<List<Integer>> ans, List<Integer> list){
        if(index == ar.length){
            if(target == 0) ans.add(new ArrayList<>(list)); //here add() is not a constant time operation
            return ;
        }
        if(ar[index] <= target){
            list.add(ar[index]);
            findCombination(index, ar, target -ar[index], ans, list);
            list.remove(list.size()-1);
        }
        findCombination(index+1,ar,target,ans,list);
    } 
}