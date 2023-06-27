import java.util.Stack;

class ReverseStack{
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

        System.out.println("Original Stack: " + stack);
        reverseStack(stack);
        System.out.println("Reversed Stack: " + stack);
    }
    public static void reverseStack(Stack<Integer> stack){
        if(stack.isEmpty()) return;
        
        if (!stack.isEmpty()) {
            int item = stack.pop();
            reverseStack(stack);
            insertAtBottom(stack, item);
        }
    }
     public static void insertAtBottom(Stack<Integer> stack, int item) {
        if (stack.isEmpty()) {
            stack.push(item);
        } else {
            int temp = stack.pop();
            insertAtBottom(stack, item);
            stack.push(temp);
        }
    }
}