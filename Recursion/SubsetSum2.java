/*Given an integer array nums that may contain duplicates, return all possible 
subsets(the power set).The solution set must not contain duplicate subsets. Return the solution in any order.
Example 1:
Input: nums = [1,2,2]
Output: [[],[1],[1,2],[1,2,2],[2],[2,2]] */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetSum2 {
    public static void main(String[] args) {
        int[] nums = {1,2,2};
        List<List<Integer>> ans = new ArrayList<>();
        /*sorting the array before passing to recursive function so that all the duplicates are side by side */
        Arrays.sort(nums);
        findSubsets(0,nums,ans, new ArrayList<>());
        System.out.println(ans);
    }
    public static void findSubsets(int index, int[]nums, List<List<Integer>> ans, List<Integer> list){
        ans.add(new ArrayList<>(list)); // creating a deep copy so that further modifications to list doesnt affect ans and it doesnt take constant time as it creates a new arraylist and copies the list elements.
        for(int i=index;i<nums.length;i++){
            if(i != index && nums[i] == nums[i-1]) continue; //to escape the duplicate elements except at the start
            list.add(nums[i]);
            findSubsets(i+1, nums, ans, list);
            list.remove(list.size()-1);
        }
    }
}
