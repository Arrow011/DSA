//Recursion
//1.Print 1 to N
//2.Print N to 1
class Recursion{
    public static void main(String[] args){
        // print1(0,10);
        // print2(10);
        backTracking1ToN(10);
        System.out.println();
        backTrackingNTo1(0, 10);
    }
    //1.Print 1 to N
    public static void print1(int i, int n){
        //base case otherwise stack overflow error might occur
        if(i > n) return ;
        System.out.print(i+" ");
        i++;
        print1(i,n);
    }
    public static void print2(int n){
        //base case otherwise stack overflow error might occur
        if(n < 1) return ;
        System.out.print(n + " ");
        n = n-1 ;
        print2(n);
    }

    public static void backTracking1ToN(int n){
        //base case
        if(n == 0) return ;
        backTracking1ToN(n-1);
        System.out.print(n+",");
    }

    public static void backTrackingNTo1(int i, int n){
        //base case
        if(i>=n) return ;
        backTrackingNTo1(++i,n);
        System.out.print(i + ",");
    }
}


