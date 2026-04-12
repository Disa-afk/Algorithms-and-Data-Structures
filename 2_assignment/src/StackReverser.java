import java.util.Stack;

public class StackReverser {
    public static void reverse(Stack<Integer> stack) {
        if (stack.isEmpty()) return;

        int top = stack.pop();
        reverse(stack);
        insertAtBottom(stack, top);
    }

    private static void insertAtBottom(Stack<Integer> stack, int value) {
        if (stack.isEmpty()) {
            stack.push(value);
            return;
        }
        int top = stack.pop();
        insertAtBottom(stack, value);
        stack.push(top);
    }

    static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        s.push(9); s.push(1); s.push(3); s.push(5); s.push(7);

        reverse(s);

        while (!s.isEmpty()) {
            System.out.print(s.pop() + " ");
        }
    }
}