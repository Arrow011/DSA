//Here we will see an example of implementing recursion using parameterised way and functional way
//1.Sum of 1 to N
//2.Factorial of N
//Time complexity : O(n) & Space Complexity : O(n) as it takes n stack space for recursive function calls
class ParameterisedVsFunctionalRecursion{
    public static void main(String[] args) {
        paramSumOf1ToN(3,0);
        System.out.println("The sum using functional way : "+functSumOf1ToN(3));
        paramFact(4, 1);
         System.out.println("The factorial using functional way : "+funcFact(4));
    }
    public static void paramSumOf1ToN(int i, int sum){
        //base case
        if(i < 0) {
            System.out.println("The sum using parameterized way : "+sum);
            return ;
        }
        paramSumOf1ToN(i-1, sum+i);
    } 

    public static int functSumOf1ToN(int i){
        //base case
        if(i == 0) return 0;
        // f(3) - 3 + f(2) --> f(2) - 2 + f(1) --> f(1) - 1 + f(0) and f(0) = 0
        return i + functSumOf1ToN(i-1);
    }

    public static void paramFact(int n, int fact){
        if(n == 0){
            System.out.println("Factorial param way: "+fact);
            return;
        }
        paramFact(n-1, fact*n);
    }

    public static int funcFact(int n){
        if(n == 1) return 1;
        return n * funcFact(n-1);
    }
}