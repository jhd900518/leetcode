package com.base.chapter03;

import java.util.Stack;

/**
 * Created by jhd on 18/3/9.
 *
 * 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
 */
public class StackForList {

    public static void main(String[] args) {

    }

    public class Solution {
        private Stack<Integer> stack1 = new Stack<>();
        private Stack<Integer> stack2 = new Stack<>();

        public void push(int val) {
            stack1.push(val);
        }

        public void pop() {
            if (stack2.isEmpty()) {
                while (!stack1.isEmpty()) {
                    stack2.push(stack1.pop());
                }
            }
            stack2.pop();
        }
    }
}
