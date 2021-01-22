package algorithm.leetcodefirstround;

import java.util.Stack;

/**
 * @author alexyan
 * @date 1/5/2020 09:35
 */
public class MinStack155 {
    /*
     * 不用long会溢出
     */

    long min;
    Stack<Long> nums;

    public MinStack155() {
        this.min = Integer.MAX_VALUE;
        this.nums = new Stack<>();
    }

    public void push(int x) {
        this.nums.push(x - this.min);
        this.min = Math.min(this.min, x);
    }

    public void pop() {
        long num = this.nums.pop();
        if (num < 0) {
            this.min -= num;
        }
    }

    /*
     * 栈顶元素 = 原始元素 - 上一个min
     * 如果栈顶元素 >= 0 (push时min不发生改变): 当前min == 上一个min 即 原始元素 == min + nums.peek()
     * 如果栈顶元素 <0 (push时min发生改变): 原始元素 == min
     */

    public int top() {
        long num = this.nums.peek();
        if (num < 0) {
            return (int) this.min;
        }
        return (int) (this.min + num);
    }

    public int getMin() {
        return (int) this.min;
    }
}
