/**Time Complexity : O(nlogn)
Space Complexity: O(n)*/
class MergeSort{
    public static void main(String[] args) {
        int ar[] = {9,8,7,6,5,4,3,2,1,0};
        int n = ar.length;
        int result[] = mergeSort(ar,0,n-1);
        for(int l : result){
            System.out.print(l+",");
        }
    }
    public static int[] mergeSort(int[] ar, int low, int high){
        if(low < high) {
            int mid = low + (high -low)/2;
            mergeSort(ar,low,mid);
            mergeSort(ar,mid+1,high);
            merge(ar,low,mid,high);
        }
        return ar;
    }
    public static void merge(int[] ar, int low, int mid, int high){
        int n1  = mid - low + 1; //length of  left array
        int n2 = high - mid; //length of right array

        /*Taking two temporary arrays L and R */
        int L[] = new int[n1];
        int R[] = new int[n2];

        /* Copying data to temporary arrays */
        for(int i=0;i<n1;i++){
            L[i] = ar[low+i];
        }
        
        for(int i=0;i<n2;i++){
            R[i] = ar[mid+1+i];
        }

        int i = 0, j = 0;
        int k = low ; //initial index of the sub array

        while(i < n1 && j < n2){
            if(L[i] < R[j]){
                ar[k++] = L[i++];
            }
            else{
                ar[k++] = R[j++];
            }
        }

        /*Copying remaining element of left and right array if any */
        while(i < n1) {
            ar[k++] = L[i++];
        }

        while(j < n2){
            ar[k++] = R[j++];
        }

    }
}