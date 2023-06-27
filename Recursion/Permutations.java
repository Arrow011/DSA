/*Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.
Example 1:
Input: nums = [1,2,3]
Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]] */

/* This approach (findAllPermute) time complexity is : O(n! * n) - n! as there are n! possible combinations and n times we are looping
 * Space complexity : O(n) + O(n) - the first one is for storing the 'list' data structure and second for the additional boolean array to keep track of picked and non picked. (ignoring the n! of 'ans')
 */
import java.util.ArrayList;
import java.util.List;

public class Permutations {
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        boolean [] freq = new boolean[nums.length]; // array to keep track of picked and not picked elements in every cycle
       // findAllPermute(n,nums,ans,freq,new ArrayList<>());
        findAllPermuteApproach2(0, nums, ans);
        System.out.println(ans);
    }
    public static void findAllPermute(int n,int[] nums, List<List<Integer>> ans, boolean[] freq, List<Integer> list){
        //base case
        if(list.size() == n){
            ans.add(new ArrayList<>(list));
            return;
        }

        for(int i = 0; i < n; i++){
            if(!freq[i]){
                list.add(nums[i]);
                freq[i] = true; // marking the ith element that it has been picked
                findAllPermute(n, nums, ans, freq, list);
                list.remove(list.size()-1);
                freq[i] = false; // unmarking the ith element i.e. it has not been picked so that it can be considered for next permutation
            }
        }
    }

    //Approach 2 : optimised for space

    public static void findAllPermuteApproach2(int index, int[]nums, List<List<Integer>> ans){
        //base case
        if(index == nums.length){
            //copying the ds into ans
            List<Integer> ds = new ArrayList<>();
            for(int i=0;i<nums.length;i++){
                ds.add(nums[i]);
            }
            ans.add(new ArrayList<>(ds));
            return;
        }

        for(int i=index;i<nums.length;i++){
            swap(i,index,nums);
            findAllPermuteApproach2(index+1, nums, ans);
            swap(i, index, nums); //reversing the swap
        }
    }
    private static void swap(int i, int j, int[] nums){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
