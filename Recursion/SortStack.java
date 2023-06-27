import java.util.Stack;

public class SortStack {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(11);
        stack.push(2);
        stack.push(32);
        stack.push(3);
        stack.push(41);

        System.out.println("Original Stack: " + stack);
        sortStack(stack);
        System.out.println("Sorted Stack: " + stack);
    }
    public static void sortStack(Stack<Integer> stack){
        if(stack.isEmpty()){
            return;
        }else{
            int item = stack.pop();
            sortStack(stack);
            insert(stack, item);
        }
    }
    public static void insert(Stack<Integer> stack, int item){
        if(stack.isEmpty()){
            stack.push(item);
        }
        else{
            int temp = stack.pop();
            insert(stack,item);
            if(stack.peek() < temp){
                int t = stack.pop();
                stack.push(temp);
                stack.push(t);
            }else{
                stack.push(temp);
            }
        }
    }
}
