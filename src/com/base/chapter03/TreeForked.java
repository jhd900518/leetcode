package com.base.chapter03;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by jhd on 18/3/8.
 * <p>
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并输出它的后序遍历序列。
 * <p>
 * 先序遍历：遍历顺序规则为【根左右】
 * <p>
 * 中序遍历：遍历顺序规则为【左根右】
 * <p>
 * 后序遍历：遍历顺序规则为【左右根】
 */

public class TreeForked {

    public static void main(String[] args) {
        int[] pre = {1, 2, 4, 7, 3, 5, 6, 8};
        int[] in = {4, 7, 2, 1, 5, 3, 8, 6};
        TreeNode node = reConstructBinaryTree(pre, in);
        List<Integer> array = postorderTraversal(node);
        for (int i = 0; i < array.size(); i++) {
            System.out.println(array.get(i));
        }
    }

    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        if (root == null)
            return result;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            result.add(node.val);
            if (node.right != null)
                stack.push(node.right);
            if (node.left != null)
                stack.push(node.left);
        }
        return result;
    }

    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        if(root == null)
            return result;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        do {
            //依次将左节点均加入栈中
            while(root != null) {
                stack.push(root);
                root = root.left;
            }
            if (!stack.isEmpty()) {
                root = stack.pop();
                result.add(root.val);
                root = root.right;
            }
        } while(!stack.isEmpty() || root != null);
        return result;
    }

    public static List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        if(root == null)
            return result;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);   //首先将根节点压栈
        while(!stack.isEmpty()) {
            TreeNode ele = stack.pop(); //首先出栈的为根节点，其后先出右子节点，后出左子节点
            if(ele.left != null)
                stack.push(ele.left);  //将左子节点压栈
            if(ele.right != null) {
                stack.push(ele.right); //将右子节点压栈
            }
            result.add(0, ele.val); //因为出栈顺序为“根右左”，所以需要每次将元素插入list开头
        }
        return result;
    }

    private static TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        return build(pre, in, 0, pre.length - 1, 0, in.length - 1);
    }

    public static TreeNode build(int[] pre,int[] in,int pstart,int pend,int istart,int iend){
        if(pstart>pend) return null;
        int cur = pre[pstart];//根节点
        int find = istart;
        while(find<=iend){//在中序遍历中查找根节点
            if(cur==in[find]) break;
            else find++;
        }
        int len = find-istart;
        TreeNode res = new TreeNode(cur);//创建根节点
        res.left = build(pre,in,pstart+1,pstart+len,istart,find-1);//创建左子树
        res.right = build(pre,in,pstart+len+1,pend,find+1,iend);//创建右子树
        return res;
    }

}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }
}

