/** Time Complexity : O(nlogn)
 * Space Complexity : O(1)
 */
class QuickSort{
    public static void main(String[] args) {
       int ar[] = {9,8,7,6,5,4,3,2,1,0};
       int low = 0, high = ar.length - 1;
       int result[] = quickSort(ar, low, high);
       for(int l: result){
        System.out.print(l+",");
       }
    }
    public static int[] quickSort(int[] ar, int low, int high) {
        if(low < high){
            /* finding a partition point which is the right position for the pivot and then keeping all the smaller elements in the left and greater elements on the right side of the partition. */
            int partition = findPartition(ar, low, high);
            quickSort(ar, low, partition-1);
            quickSort(ar, partition+1, high);
        }
      return ar;
    }
    public static int findPartition(int[] ar, int low, int high){
        /** considering pivot as the first element, can be any other like mid or last */
        int pivot = ar[low];
        int i = low, j = high;

        while(i<j){
            //for descending order just change the sign to ar[i] >= pivot and ar[i] > pivot
            while(ar[i] <= pivot && i <= high - 1){
                i++;
            }
            while(ar[i] > pivot && j >= low +1){
                j--;
            }

            if(i < j){
              swap(ar, i, j);
            }
        }
        swap(ar,low, j);
        return j;
    }

    public static void swap(int ar[], int i, int j){
        int temp = ar[i];
        ar[i] = ar[j];
        ar[j] = temp;
    }
}