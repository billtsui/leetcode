import java.util.Stack;

/*
 * @lc app=leetcode.cn id=232 lang=java
 *
 * [232] 用栈实现队列
 */

// @lc code=start
class MyQueue {
    Stack<Integer> stack;
    Stack<Integer> temp_stack;

    /** Initialize your data structure here. */
    public MyQueue() {
        stack = new Stack();
        temp_stack = new Stack();
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        while(!stack.isEmpty()){
            temp_stack.push(stack.peek());
            stack.pop();
        }
        temp_stack.push(x);
        while(!temp_stack.isEmpty()){
            stack.push(temp_stack.peek());
            temp_stack.pop();
        }
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        return stack.pop();
    }
    
    /** Get the front element. */
    public int peek() {
        return stack.peek();
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stack.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
// @lc code=end

