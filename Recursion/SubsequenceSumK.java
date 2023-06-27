// Pint subsequences with sum equal to k 
// ar = [1,2,1] sum = 2 --> [1,1] , [2]
// handling the scenario when we only want to print the first found subsequence 
// counting no of subsequence that have sum = k

import java.util.ArrayList;
import java.util.List;

class SubsequenceSumK{
    public static void main(String[] args) {
        int a[] = {1,2,1};
        int n = a.length, sum = 0, k =2;
        List<Integer> list = new ArrayList<>();
        printSubsequence(0,n,a, list, sum,k);
        System.out.println(countSubsequence(0, n, a, sum, k));
    }
    public static boolean printSubsequence(int index, int n, int ar[], List<Integer> list, int sum, int k){
        if(index == n){
            //condition satisfied
            if(sum == k){
                System.out.println(list);
                return  true; // for printing the first found subsequence
            } 
            //condition not satified
            return false;
        }

        //pick case
        list.add(ar[index]);
        sum += ar[index];
        if(printSubsequence(index+1, n, ar, list, sum, k) == true){
            return true;
        }

        //not pick case
        list.remove(list.size()-1);
        sum -= ar[index];
        if(printSubsequence(index+1, n, ar, list, sum, k) == true) {
            return true;
        }
        return false;
    }

    public static int countSubsequence(int index, int n, int ar[], int sum, int k){
        if(index == n){
            //condition satisfied
            if(sum == k)
                return  1; 
            //condition not satified
            return 0;
        }

        //pick case
        sum += ar[index];
        int l = countSubsequence(index+1, n, ar, sum, k);

        //not pick case
        sum -= ar[index];
        int r = countSubsequence(index+1, n, ar, sum, k);

        return l+r;
    }
}