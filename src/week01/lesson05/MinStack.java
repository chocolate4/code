package week01.lesson05;

import java.util.LinkedList;
import java.util.Stack;

//todo：引入其他数据结构来维护一个值
public class MinStack {
    //todo：栈本身
    Stack<Integer> stack = new Stack<>();
    //todo：维护前缀最小值
    Stack<Integer> min = new Stack<>();
    public MinStack() {}
    public void push(int val) {
        if(stack.empty()) min.push(val);
        else min.push(Math.min(min.peek(),val));
        stack.push(val);
    }
    public void pop() {min.pop(); stack.pop();}
    public int top() {return stack.peek();}
    public int getMin() {return min.peek();}
}
