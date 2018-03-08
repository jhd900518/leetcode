package com.base.chapter03;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by jhd on 18/3/8.
 *
 * 输入一个链表，从尾到头打印链表每个节点的值。
 * 反过来打印。显然，先入栈，再出栈即可。
 */
public class TailToHead {

    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 8, 9, 6};
        ListNode listNode = buildListNode(arr);
        if (listNode != null) {
            ArrayList<Integer> arrayList = printListFromTailToHead(listNode);
            for (int i = 0; i < arrayList.size(); i++) {
                System.out.println(arrayList.get(i));
            }
        }
    }

    private static ListNode buildListNode(int[] array) {
        if (array == null || array.length == 0) {
            return null;
        }
        ListNode first = null, last = null, newNode;

        for (int i = 0; i < array.length; i++) {
            newNode = new ListNode(array[i]);
            newNode.next = null;
            if (first == null) {
                first = newNode;
                last = newNode;
            } else {
                last.next = newNode;
                last = newNode;
            }

        }
        return first;
    }

    public static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        Stack<Integer> stack = new Stack<>();
        ListNode p = listNode;
        while (p != null) {
            stack.add(p.val);
            p = p.next;
        }
        ArrayList<Integer> arr = new ArrayList<>();
        while (stack.size() != 0) {
            arr.add(stack.pop());
        }
        return arr;
    }
}

class ListNode {
    int val;
    ListNode next = null;

    public ListNode(int val) {
        this.val = val;
    }
}
