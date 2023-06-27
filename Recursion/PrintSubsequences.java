import java.util.ArrayList;
import java.util.List;

class PrintSubsequences{
    public static void main(String[] args) {
        int ar [] = {3,1,2};
        int n = ar.length;
        List<Integer> list = new ArrayList<>();
        generatePossibleSubsequences(0,ar,3,list);
    }
    public static void generatePossibleSubsequences(int index, int []ar, int n, List<Integer> list){
        if(index == n) {
            System.out.println(list);
            return ;
        }

        //At each index there are two options either to choose to add the element in the list or not to choose

        //case for taking the index element 
        generatePossibleSubsequences(index+1, ar, n, list);
        list.add(ar[index]); 

        //now to execute second case i.e when we are not taking the index element to be added in the list
        // we first need to remove the element added in the previous step
        generatePossibleSubsequences(index+1, ar, n, list);
        list.remove(list.size()-1);
    }
}