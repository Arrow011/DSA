import java.util.ArrayList;
import java.util.List;

public class SubsetSum1PowerSet {
    static List<Integer> list = new ArrayList<>();
    public static void main(String[] args) {
        int arr[] = {2, 3};
        int n = arr.length;
        allSubsets(arr,n);
    }
    public static void allSubsets(int[] ar, int n){
         int x = (int)Math.pow(2,n) - 1;
          for(int i=0;i<=x;i++){
            int sum = 0;
            
            for(int j=0; j<n;j++){
                // 1 << j is left shift binary operator ex. 1<<2 means 0100 (1 shifted to two bits left)
                // i & 1<<j : checks if the bit at the index is set if its not zero else it is not set
                if((i & (1<<j)) != 0){
                    sum += ar[j];
                }
                
            }
            list.add(sum);
        }
        System.out.print(list);
    }
}
