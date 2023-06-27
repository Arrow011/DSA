//Time Complexity: O(n/2) & Space Complexity : O(n/2) - n/2 stack space as n/2 function calls will be waiting
class PalindromeString{
    public static void main(String[] args) {
        String s = "Ankur";
        String st = "aabaa";
        //checkPalindrome(0,s);
        boolean flag = checkPalindrome(0,s);

        if(flag){
            System.out.print("Palindrome");
        }else{
            System.out.print("Not palindrome");
        }
    }
    public static boolean checkPalindrome(int i,String s){
        int n = s.length();
        if(i >= n/2) return true;
        if(s.charAt(i) != s.charAt(n-i-1)){
            return false;
        }
        return checkPalindrome(i+1,s);
    }
}