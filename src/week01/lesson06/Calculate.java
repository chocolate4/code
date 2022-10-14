package week01.lesson06;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

/**
 * 中缀表达式
 */
public class Calculate {
    public static void main(String[] args) {
        System.out.println(new Calculate().calculate("42"));
    }
    public int calculate(String s) {
        //todo: 中缀 -> 后缀
        Queue<Character> queue = new ArrayDeque<>();
        Stack<Character> token = new Stack<>();
        Boolean flag = true;
        for(char c : s.toCharArray()){
            if(c == ' ') continue;
            if(c == '*' || c == '/'){
                flag = false;
                if(token.empty()){
                    token.push(c);
                }else if(token.peek() == '*' || token.peek() == '/'){
                    queue.add(token.pop());
                    token.push(c);
                }else if(token.peek() == '+' || token.peek() == '-') {
                    token.push(c);
                }
            }else if(c == '+' || c == '-'){
                flag = false;
                if(token.empty()) {
                    token.push(c);
                }else if(token.peek() == '+' || token.peek() == '-'){
                    queue.add(token.pop());
                    token.push(c);
                }else if(token.peek() == '*' || token.peek() == '/'){
                    queue.add(token.pop());
                    token.push(c);
                }
            }else{
                queue.add(c);
            }
        }

        while (!token.empty()) {
            queue.add(token.pop());
            if(token.empty()) break;
        }

        StringBuilder stringBuilder = new StringBuilder();
        while (!queue.isEmpty()){
            stringBuilder.append(queue.poll());
        }
        String[] split = stringBuilder.toString().split("");
        //todo: 中缀表达式计算
        if(flag){
            return Integer.valueOf(stringBuilder.toString());
        }
        return evalRPN(split);
    }
    public int evalRPN(String[] tokens) {
        Stack<Integer> num = new Stack<>();
        for(String s : tokens){
            if(s.equals("+")){
                int one = num.pop();
                int two = num.pop();
                num.push(two+one);
            }else if(s.equals("-")){
                int one = num.pop();
                int two = num.pop();
                num.push(two-one);
            }else if(s.equals("*")){
                int one = num.pop();
                int two = num.pop();
                num.push(two*one);
            }else if(s.equals("/")){
                int one = num.pop();
                int two = num.pop();
                num.push(two/one);
            }else{
                num.push(Integer.valueOf(s));
            }
        }
        return num.peek();
    }
}
