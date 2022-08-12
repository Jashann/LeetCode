import java.util.Stack;

public class StackC {
    // Stack - Problem 1
    public boolean isValid(String s) {

        if (s.length() % 2 != 0)
            return false;

        java.util.Stack<Character> stack = new java.util.Stack<Character>();

        for ( int i=0; i<s.length(); i++ ) {
            char c = s.charAt(i);

            if ( c == '{' || c == '[' || c == '(' )
                stack.push(c);
            else {
                if( stack.isEmpty() || getOpposite( stack.pop() ) != c )
                    return false;
            }
        }

        return stack.isEmpty();
    }

    public char getOpposite(char c) {
        if ( c == '{' )
            return '}';
        if ( c == '[' )
            return ']';
        if ( c == '(' )
            return ')';
        return 'n';
    }

    // Stack - Problem 1
    class MinStack {
        Stack<Integer> stack    = new Stack<>();
        Stack<Integer> minStack = new Stack<>();

        public void push(int x)
        {
            if( stack.empty() || x <= minStack.peek() )
                minStack.push(x);
            stack.push(x);
        }

        public void pop()
        {
            if(stack.peek().equals(minStack.peek()))
                minStack.pop();
            stack.pop();
        }

        public int top()
        {
            return stack.peek();
        }

        public int getMin()
        {
            return minStack.peek();
        }
    }

    public static void main(String[] args) {
        StackC stack = new StackC();
        System.out.println( stack.isValid("()[]{}") );
    }
}
