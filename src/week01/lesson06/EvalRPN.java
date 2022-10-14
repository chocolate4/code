package week01.lesson06;

import java.util.Stack;

/**
 * 后缀表达式
 */
public class EvalRPN {
    public static void main(String[] args) {
        final String[] strings = {"4","13","5","/","+"};
        System.out.println(new EvalRPN().evalRPN(strings));
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
