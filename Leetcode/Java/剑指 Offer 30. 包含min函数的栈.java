/**
 * 方法1：辅助栈中每次压入（x和栈顶元素中的最小值）
 */
class MinStack {
    /** initialize your data structure here. */
 Stack<Integer> stack1;
 Stack<Integer> stack2;
 public MinStack() {
     this.stack1 = new Stack<>();
     this.stack2 = new Stack<>(); //存放最小值的栈
 }

 public void push(int x) {
    stack1.push(x);
    if(!stack2.isEmpty()&&stack2.peek()<x)
        stack2.push(stack2.peek());
    else
        stack2.push(x);
 }

 public void pop() {
     stack1.pop();
     stack2.pop();
 }

 public int top() {
     return stack1.peek();
 }

 public int min() {
    return stack2.peek();
 }
}