class ReverseArray{
    public static void main(String[] args) {
        int a [] = {1,2,3,4,5,6,7,8};
        int n = a.length;
        //iterative approach
        // for(int i=0;i<n/2;i++){
        //     int temp = a[i];
        //     a[i] = a[n-i-1];
        //     a[n-i-1] = temp;
        // }

        //recusive approach
        funcReverse(0,n,a);
        for(int i : a){
            System.out.print(i+" ");
        }

    }
    public static void funcReverse(int i,int n, int[] a){
        if(i >= n/2) return ;
        int temp = a[i];
        a[i] = a[n-i-1];
        a[n-i-1] = temp;

        funcReverse(i+1, n, a);
    }
}