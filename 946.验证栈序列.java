import java.util.Stack;

/*
 * @lc app=leetcode.cn id=946 lang=java
 *
 * [946] 验证栈序列
 */

// @lc code=start
class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        if(pushed.length == 0 || popped.length == 0){
            return false;
        }

        Stack<Integer> stack = new Stack<Integer>();
        
        int n = pushed.length;
        int l = 0;

        for (int i = 0; i < n; i++) {
            stack.push(pushed[i]);
            while(!stack.empty() && (popped[l] == stack.peek())){
                l++;
                stack.pop();
            }
        }

        return stack.empty();
    }
}
// @lc code=end

