//Example of multiple recursion calls - it executes linearly  first the first function call until it returns second wont start
//Time Complexity : O(2^n) (near exponential as every call has two further calls)
class Fibonacci{
    public static void main(String[] args) {
        int a = fibo(6);
        for(int i=-0;i<7;i++){
            System.out.print(fibo(i)+" ");
        }
    }
    public static int fibo(int n){
        if(n <= 1) return n;

        int first = fibo(n-1);
        int second = fibo(n-2);

        //System.out.println(first + second) ;
        return first + second;
    }
}