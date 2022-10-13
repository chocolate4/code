package week01.lesson05;

import java.util.Stack;

public class IsValid {
    public static void main(String[] args) {
        String s = "(({()})))";
        boolean valid = new IsValid().isValid(s);
        System.out.println(valid);
    }
    public boolean isValid(String s) {
        if(s.length() % 2 != 0) return false;
        //todo：创建栈存储左括号
        Stack<Character> stack = new Stack<>();
        for(char c : s.toCharArray()){
            if(c == '(' || c == '[' || c == '{'){
                stack.push(c);
            }else{
                if(stack.empty()) return false;
                if(stack.peek() == '(' && c != ')') return false;
                if(stack.peek() == '[' && c != ']') return false;
                if(stack.peek() == '{' && c != '}') return false;
                stack.pop();
            }
        }
        return stack.empty();
    }
}
