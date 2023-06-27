
public class RecursiveAtoiSimple {
    public static void main(String[] args) {
        String s = "42256";
        int n = s.length();
        System.out.println(atoi(s,n));
    }
    public static int atoi(String s, int n){
        if(s == "") return 0;

        if(n == 1){
            return s.charAt(0) - '0';
        }
        return 10* atoi(s, n-1) + s.charAt(n-1) - '0';
    }
}
