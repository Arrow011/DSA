/*Input:
N = 2
arr[] = {2, 3}
Output:
0 2 3 5
Explanation:
When no elements is taken then Sum = 0.
When only 2 is taken then Sum = 2.
When only 3 is taken then Sum = 3.
When element 2 and 3 are taken then 
Sum = 2+3 = 5. */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SubsetSum1 {
    public static List<Integer> list = new ArrayList<>();
    public static void main(String[] args) {
        int arr[] = {2, 3};
        subsetSum(arr,0,0);
        Collections.sort(list);
        System.out.println(list);
    }
    public static void subsetSum(int[] ar , int index, int sum){
        if(index >= ar.length){
            list.add(sum);
            return;
        }

        subsetSum(ar, index+1, sum + ar[index]);
        subsetSum(ar, index+1, sum);
    }
}
