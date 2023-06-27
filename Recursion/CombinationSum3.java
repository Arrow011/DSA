import java.util.ArrayList;
import java.util.List;

class CombinationSum3{
    public static void main(String[] args) {
        int[] ar = {1,2,3,4,5,6,7,8,9};
        int target = 7, k = 3;
        List<List<Integer>> result = findCombinationSum3(0,ar,target,k);
        System.out.print(result);
    }
    public static List<List<Integer>> findCombinationSum3(int index, int[]ar, int target, int k){
        List<List<Integer>> ans = new ArrayList<>();
        findCombination(index,ar,target,k,ans,new ArrayList<>());
        return ans;
    }
    public static void findCombination(int index, int[]ar, int target, int k, List<List<Integer>>ans, List<Integer> list){
        if(target == 0 && list.size() == k ){
            ans.add(new ArrayList<>(list));
            return;
        }

        for(int i=index;i<ar.length;i++){
            if(i > index && ar[i] == ar[i-1]){
                continue;
            }
            if(ar[i] > target) break;
            list.add(ar[i]);
            findCombination(i + 1, ar, target - ar[i], k, ans, list);
            list.remove(list.size()-1);
        }
    }
}