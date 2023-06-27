import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class CombinationSum2{
    public static void main(String[] args) {
        int[] candidates = {2,5,2,1,2};
        int target = 5;
        CombinationSum2 cs = new CombinationSum2();
        List<List<Integer>> result = cs.combinationSum2(candidates, target);
        System.out.print(result);
    }
     public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates);
        findCombinationSum2(0, candidates, target, ans, new ArrayList<>());
        return ans;
    }
    public void findCombinationSum2(int index, int[] ar, int target, List<List<Integer>> ans, List<Integer> ds){
        if(target == 0) {
            ans.add(new ArrayList<>(ds));
            return;
        }

       for(int i=index;i<ar.length;i++){
           /** i > index as for the first element we need to keep it irrespective of being duplicate */
           if(i > index && ar[i] == ar[i-1]) {
                continue;
           }
           if(ar[i] > target) break;
           ds.add(ar[i]);
           findCombinationSum2(i+1,ar,target-ar[i],ans,ds);
           ds.remove(ds.size()-1);
        }
    }
}